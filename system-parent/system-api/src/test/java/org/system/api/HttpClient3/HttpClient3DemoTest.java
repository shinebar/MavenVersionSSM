package org.system.api.HttpClient3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.system.api.httpClient3.HttpClient3Demo;

public class HttpClient3DemoTest {
    private static final Log LOG=LogFactory.getLog(HttpClient3DemoTest.class);
	
    @Test
	public void testPostMethod() {
		try {
			for (int i = 0; i < 100; i++) {
				String url = "http://10.230.28.121:8085/trade-web/webservice/fossSettleSearch/settleByFossPtp";
				String requestJson = "{\"sourceNo\":\"5563901510\"}";
				String response = HttpClient3Demo.postMetod(url, requestJson);
				System.out.println(response);
				//LOG.info(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
