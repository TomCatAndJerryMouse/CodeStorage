package HttpClientUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Admin
 *
 */
public class Http5ClientUtils {
	
	private final static Logger log =  LogManager.getLogger(Http5ClientUtils.class);
	
    static  CloseableHttpClient httpclient = HttpClients.custom()
            .setDefaultCookieStore(new BasicCookieStore())
            .build();
    /**
     * @param url
     * @param params 参数
     * @return
     * @throws IOException
     */
    public static String post(String url,Map<String,String> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        // 设置消息头
        httpPost.setEntity(new StringEntity(JSON.toJSONString(params)));
        httpPost.addHeader("Content-Type","application/json");
        sendRequest(httpPost);
        return null;
    }
    
    /**
     * @param url
     * @param paraMap
     * @return
     * @throws IOException
     */
    public static String get(String url,Map<String,String> paraMap) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        // 如果有数据组装表单数据
        if (paraMap != null) {
                List<NameValuePair> paramList = new ArrayList<>();
            for (String key : paraMap.keySet()) {
                    paramList.add(new BasicNameValuePair(key, paraMap.get(key)));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
            httpGet.setEntity(entity);
        }
        sendRequest(httpGet);
        return  null;
    }

    /**
     * 处理请求响应
     */
    private static JSONObject sendRequest(HttpUriRequestBase httpReq){
    	 try (CloseableHttpResponse response = httpclient.execute(httpReq)) {
	         String resultString = EntityUtils.toString(response.getEntity(),"utf-8");
	     	 JSONObject jsonObject  = (JSONObject) JSON.parse(resultString);
	     	 String retType = jsonObject.getString("type");
 			 String retMessage= jsonObject.getString("message");
	     	 if (null != retType && null != retMessage){
	     		log.info(retType + " " +  retMessage);
	     	 } else {
	     		log.error(SysMessage.UNKNOWNERROR);
	     	 }
	         return jsonObject;
         } catch (ParseException e) {
        	 log.error(SysMessage.EXCEPTION + " " +  e.getMessage());
        	 return SysMessage.getClinetMsg(SysMessage.EXCEPTION,e.getMessage());
         } catch (IOException e) {
        	 log.error(SysMessage.EXCEPTION + " " +  e.getMessage());
        	 return SysMessage.getClinetMsg(SysMessage.EXCEPTION,e.getMessage());
	    }
    }
}
