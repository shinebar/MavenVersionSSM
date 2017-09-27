package org.system.api.httpClient3;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpClient3Demo {
	
	private  static final Log LOG=LogFactory.getLog(HttpClient3Demo.class);
	
	public static String postMetod(String url, String requestJson) throws Exception {
		
		StringRequestEntity reqEntity = new StringRequestEntity(requestJson, "application/json", "UTF-8");
		
		LOG.info("---传给结算获取财务信息, 调cubc接口请求参数" + requestJson);
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		String response = "";
		try {
			post.setRequestEntity(reqEntity);
			post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
			// 设置连接超时时间
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
			// 设置处理超时时间
			httpClient.getHttpConnectionManager().getParams().setSoTimeout(3000);
			httpClient.executeMethod(post);
			response = post.getResponseBodyAsString();
		} catch (Exception e) {
			throw e;
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
			try {
				httpClient.getHttpConnectionManager().closeIdleConnections(0);
			} catch (Exception e2) {
				LOG.info(e2);
			}
		}
		return response;
	}
}
