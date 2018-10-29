package com.Li.config.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 
 * @ClassName: KaptchaFilter
 * @Description: 验证码管理类
 * @author: L-ZP
 * @date: 2018年11月12日 下午2:01:00 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class KaptchaFilter extends FormAuthenticationFilter {

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	// 登录验证
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

		CaptchaUsernamePasswordToken token = createToken(request, response);
		String username = token.getUsername();
		try {
			// System.out.println("KaptchaFilter.executeLogin");
			/* 图形验证码验证 */
			doCaptchaValidate((HttpServletRequest) request, token);
			Subject subject = getSubject(request, response);
			subject.login(token);// 正常验证

			// 到这里就算验证成功了,把用户信息放到session中
			((HttpServletRequest) request).getSession().setAttribute("name", username);

			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			return onLoginFailure(token, e, request, response);
		}
	}

	// 验证码校验
	protected void doCaptchaValidate(HttpServletRequest request, CaptchaUsernamePasswordToken token) {
		// System.out.println("KaptchaFilter.doCaptchaValidate");

		// session中的图形码字符串
		String captcha = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// System.out.println("session中的图形码字符串:"+captcha);

		// 比对
		if (captcha == null || !captcha.equalsIgnoreCase(token.getCaptcha())) {
			throw new IncorrectCredentialsException();
		}
	}

	@Override
	protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new CaptchaUsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha);
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	// 保存异常对象到request
	@Override
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae);
	}
}
