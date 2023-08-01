package cn.ty.util.http5;

import com.alibaba.fastjson.JSONObject;

public class SysMessage {
	public static final String UNKNOWNERROR="未知错误";
	public static final String EXCEPTION="异常";
	
	public static JSONObject getClinetMsg(String disc,String message){
		JSONObject msgObject = new JSONObject();
		msgObject.put("source", "client");
		msgObject.put("disc", disc);
		msgObject.put("message", disc);
		return  (JSONObject)msgObject ;
	}
}
