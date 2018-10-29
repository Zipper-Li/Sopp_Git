package com.Li.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName:  JsonUtils   
 * @Description: 自定义响应结构, 转换类
 * @author: L-ZP
 * @date:   2018年11月6日 上午10:10:47     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 
     * objectToJson   
     * @Description: 将对象转换成json字符串。
     * @param: @param data
     * @param: @return      
     * @author: L-ZP
     * @time: 上午10:10:57      
     * @throws   
     * @return: String
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    
    /**
     * 
     * jsonToPojo   
     * @Description: 将json结果集转化为对象
     * @param: @param jsonData json数据
     * @param: @param clazz 对象中的object类型
     * @param: @return      
     * @author: L-ZP
     * @time: 上午10:11:10      
     * @throws   
     * @return: T
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
     * jsonToList   
     * @Description: 将json数据转换成pojo对象list
     * @param: @param jsonData
     * @param: @param beanType
     * @param: @return      
     * @author: L-ZP
     * @time: 上午10:11:36      
     * @throws   
     * @return: List<T>
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
}
