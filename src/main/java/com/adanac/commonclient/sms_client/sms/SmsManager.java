package com.adanac.commonclient.sms_client.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.adanac.commonclient.sms_client.common.Constant;

/**
 * 短信网关实现类
 *
 */
public class SmsManager {

	/**
	 * @author forgive56
	 * @param mobile 用户手机号
	 * @param code 需要发送的验证码
	 * @return
	 * 000                          未知错误
	 * 100			发送成功
	   101			验证失败
	   102			手机号码格式不正确
	   103			会员级别不够
	   104			内容未审核
	   105			内容过多
	   106			账户余额不足
	   107			Ip受限
	   108			手机号码发送太频繁，请换号或隔天再发
	   109			帐号被锁定
	   110			手机号发送频率持续过高，黑名单屏蔽数日
	   120			系统升级
	
	 */
	public static String sendVC(String mobile, String code) {
		// 0表示未知异常
		String result = Constant.TP_SMS_UN_ERROR;
		try {
			// 校验码模板url
			String vcurl = Constant.TP_SMS_URL + Constant.TP_SMS_QUE + Constant.TP_SMS_ACCOUNT + Constant.TP_SMS_AND
					+ Constant.TP_SMS_PASSWORD + Constant.TP_SMS_AND + Constant.TP_SMS_MOBILE + mobile
					+ Constant.TP_SMS_AND + Constant.TP_SMS_CONTENT
					+ URLEncoder.encode(Constant.TP_SMS_M_VC_L + code + Constant.TP_SMS_M_VC_R, "utf-8");
			// System.out.println(vcurl);
			result = readContentFromGet(vcurl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}

		return result;
	}

	// 发送http请求
	private static String readContentFromGet(String getURL) throws IOException {

		URL getUrl = new URL(getURL);
		// 根据拼凑的URL，打开连接，URL.openConnection函数会根据URL的类型，
		// 返回不同的URLConnection子类的对象，这里URL是一个http，因此实际返回的是HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
		// 服务器
		connection.connect();
		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		System.out.println("=============================");
		System.out.println("Contents of get request");
		System.out.println("=============================");
		String lines = "";
		String str_result = "";
		while (true) {
			str_result += lines;
			lines = reader.readLine();
			if (lines == null) {
				break;
			}
			System.out.println(lines);
		}
		reader.close();
		// 断开连接
		connection.disconnect();
		System.out.println("=============================");
		System.out.println("Contents of get request ends");
		System.out.println("=============================");
		return str_result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(sendVC("13800000000", "1234"));
			// readContentFromPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
