package cn.ty.util.http5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Htt5Test {
	@Test
    public  void longin () {
        Map<String,String> pm = new HashMap<String,String>();
        pm.put("username", "admin");
        pm.put("password", "admin");
        try {
        	Http5ClientUtils.post("http://127.0.0.1:8080/rest/user/login",pm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void info () {
        longin ();
        Map<String,String> pm = new HashMap<String,String>();
        pm.put("username", "admin");
        pm.put("password", "admin");
        try {
        	Http5ClientUtils.get("http://127.0.0.1:8080/rest/user/info",pm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
