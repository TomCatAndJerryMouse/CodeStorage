package cn.ty.util.http5;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Request {
	
	public static void main(String[] args) {
		String jsonStr = "{\"templateCode\": \"TENGYI\",\"nodeList\": [{\"FZ-YHJBXX\": {\"PersonName\": \"teng\",\"idType\": \"101\",\"IDNumber\": \"542121198807030018\",\"Phone\": \"18228387154\"},\"nodeCode\": \"XnUserInfo\"}]}";
		httpPostWithJson("http://192.168.92.151:8081/frontserver/customer/syn",jsonStr,"1263f4155c9f","1239bd8c1cc0");
	}

	public static String httpPostWithJson(String url,String jsonStr,String appId, String appSecret){
		HttpPost post = null;
		try {
			//创建CloseableHttpClient
			HttpClientBuilder builder = HttpClientBuilder.create();
			CloseableHttpClient httpClient = builder.build();
			post = new HttpPost(url);
			// 构造消息头
			post.setHeader("Content-type", "application/json; charset=utf-8");
			post.setHeader("Connection", "Close");
			post.setHeader("appId", appId);
			post.addHeader("hmac", hmac(appSecret, jsonStr));
			// 构建消息实体
			StringEntity entity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
			entity.setContentEncoding("UTF-8");
			// 发送Json格式的数据请求
			entity.setContentType("application/json");
			post.setEntity(entity);
			HttpResponse response = httpClient.execute(post);
			// 检验返回码
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode != HttpStatus.SC_OK) {
				System.out.println("服务器返回的http状态码错误:" + statusCode);
				return null;
			} else {
				String ret = EntityUtils.toString(response.getEntity());
				System.out.println(ret);
	        }
	    } catch (Exception e) {
	    	System.out.println( e);
		}
		finally
		{
			if(post != null){
				post.releaseConnection();
	        }
	    }
		return null;
	}
	
	/**
	 * @paramsecretKeyappId对应的秘钥
	 * @paramjsonStr son数据
	 * @return
	 */
	public static String hmac(String secretKey,String jsonStr) {
		try {
			SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("utf-8"), "HmacSHA1");
			Mac  mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(jsonStr.getBytes("utf-8"));
			return new String(Base64.getEncoder().encode(rawHmac));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
