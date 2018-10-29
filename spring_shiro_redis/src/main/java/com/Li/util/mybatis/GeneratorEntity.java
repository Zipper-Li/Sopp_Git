package com.Li.util.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 
 * @ClassName:  GeneratorEntity   
 * @Description: 逆向的实体类以及对应配置
 * @author: L-ZP
 * @date:   2018年11月6日 上午10:24:14     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class GeneratorEntity {

	/*
	 * taotao商城的设置 "tb_content", "tb_content_category", "tb_item", "tb_item_cat",
	 * "tb_item_desc", "tb_item_param", "tb_item_param_item", "tb_order",
	 * "tb_order_item", "tb_order_shipping", "tb_user","tb_log"
	 */

	/*private static String[] arrays = new String[] { "tb_content", "tb_content_category", "tb_item", "tb_item_cat",
			"tb_item_desc", "tb_item_param", "tb_item_param_item", "tb_order", "tb_order_item", "tb_order_shipping",
			"tb_user", "tb_log" };*/
	
	private static String[] arrays = new String[] {"advertisement", "article", "blog_info", "comment_info",
			"link", "message", "permission", "private_message", "role", "role_permission", "system_notice", "type",
			"user_group", "user_group_role", "user_info", "user_notice", "visit", "words_info","log"};
	
	public static void main(String[] args) {
		String packageName = "com.Li";
		boolean serviceNameStartWithI = false;
		// 执行表格生成代码。
		generateByTables(serviceNameStartWithI, packageName, arrays);
	}

	public static void generateByTables(boolean serviceNameStartWithI, String packageName, String[] array) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = "mycode";
		// 设置输出路径，作者，是否打开，配置不允许二级缓存。
		gc.setOutputDir(gc.getOutputDir() + projectPath).setAuthor("Sopp").setOpen(true).setFileOverride(true).setDateType(DateType.ONLY_DATE);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		//配置数据库路径，驱动，数据库用户名，数据库密码。
		dsc.setUrl("jdbc:mysql://localhost:3306/blog_li?useSSL=false&serverTimezone=UTC")
				.setDriverName("com.mysql.jdbc.Driver").setUsername("root").setPassword("root");
		

		// 包配置
		PackageConfig pc = new PackageConfig();
		//配置父包的名，设置模块名称。这里的模块名，是对应功能模块的名称.setModuleName("123")
		pc.setParent(packageName);
		//配置实体类，service和实现类，mapper，以及mappers。
		pc.setEntity("pojo").setService("service").setMapper("mapper").setServiceImpl("service.impl").setXml("mapper.mappers");
		

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// 数据库表映射到实体的命名策略:underline_to_camel
		strategy.setNaming(NamingStrategy.underline_to_camel);
		// 数据库表字段映射到实体的命名策略:underline_to_camel
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// 自定义继承的Entity类全称，带包名
		// strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		// lombok模式
		strategy.setEntityLombokModel(true);
		// 设置restcontroller的风格
		strategy.setRestControllerStyle(true);
		// strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		// 设置数据库表名
		strategy.setInclude(arrays);
		// strategy.setSuperEntityColumns("id");
		// 驼峰命名转换
		strategy.setControllerMappingHyphenStyle(true);
		// 移除Boolean的is前缀
		strategy.setEntityBooleanColumnRemoveIsPrefix(true);
		strategy.setVersionFieldName("version");
		// 表前缀
		// strategy.setTablePrefix(pc.getModuleName() + "_");
		//配置整体运行。
		mpg.setGlobalConfig(gc);
		mpg.setDataSource(dsc);
		mpg.setPackageInfo(pc);
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}

}
