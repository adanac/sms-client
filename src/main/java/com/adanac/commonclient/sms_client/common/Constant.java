package com.adanac.commonclient.sms_client.common;

/**
 * sms常量类
 */
public class Constant {
	// 第三方短信网关url
	public static final String TP_SMS_URL = "http://sms.106jiekou.com/utf8/sms.aspx";

	// ?连接符
	public static final String TP_SMS_QUE = "?";

	// &连接符
	public static final String TP_SMS_AND = "&";

	// 未知异常
	public static final String TP_SMS_UN_ERROR = "000";

	// 第三方短信网关链接用account
	public static final String TP_SMS_ACCOUNT = "account=bizcent";

	// 第三方短信网关链接用password
	public static final String TP_SMS_PASSWORD = "password=bizcent";

	// 第三方短信网关链接用mobile
	public static final String TP_SMS_MOBILE = "mobile=";

	// 第三方短信网关链接用content
	public static final String TP_SMS_CONTENT = "content=";

	// 第三方短信网关验证码模板头
	public static final String TP_SMS_M_VC_L = "您的验证密码是：";

	// 第三方短信网关验证码模板尾
	public static final String TP_SMS_M_VC_R = "，如需帮助请联系客服。";
}
