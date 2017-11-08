package org.system.api.httpClient3;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hamcrest.core.Is;
import org.junit.Assume;

public class HttpClient4Demo {
	
	private  static final Log LOG=LogFactory.getLog(HttpClient4Demo.class);
	
	public static String postMetod(String url, String requestJson) throws Exception {
		
		//StringRequestEntity reqEntity = new StringRequestEntity(requestJson, "application/json", "UTF-8");
		StringEntity reqEntity=new StringEntity(requestJson,Consts.UTF_8);
		LOG.info("调接口请求参数" + requestJson);
		//CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		RequestConfig requestConfig=RequestConfig.custom()
				.setConnectTimeout(3000)
				.setConnectionRequestTimeout(1000)
				.setSocketTimeout(3000).build();
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/json;charset=UTF-8");
//	    post.setProtocolVersion(new ProtocolVersion("http",1 , 0));
		post.setConfig(requestConfig);
		post.setEntity(reqEntity);
		String response = "";
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			CloseableHttpResponse httpResponse = client.execute(post);
			if (httpResponse != null && httpResponse.getStatusLine() != null) {
				//返回对象 向上造型  
	            HttpEntity httpEntity = httpResponse.getEntity();  
	            if(httpEntity != null){  
	            	response=EntityUtils.toString(httpEntity, Consts.UTF_8);
	                //响应输入流  
	                //InputStream is = httpEntity.getContent();
	                //转换为字符输入流  
	                //BufferedReader br = new BufferedReader(new InputStreamReader(is,Consts.UTF_8));  
	                //while((response=br.readLine())!=null){  
	                   // System.out.println("sysout:"+response);  
	                //}  
	                //关闭输入流  
	                //is.close();  
	            } 
				Assume.assumeThat(httpResponse.getStatusLine().getStatusCode(), Is.is(200));
			}
			LOG.info("response:"+response);
		} catch (IOException e) {
			throw new IllegalArgumentException("Server does not seem to be running", e);
		}
		return response;
	}
}
