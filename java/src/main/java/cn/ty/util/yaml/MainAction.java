package cn.ty.util.yaml;

import java.util.Date;

public class MainAction {
	
	public static void main(String[] args) {
		ConfigReder yr = ConfigReder.getInstance();
		NodeObject a = yr.getNodeObjectByKeys("apigateServierInfo");
		System.out.println("SSS " + a.getStringValue("url"));
		String ret = yr.getValueByKeys("appinfo.appsecrt");
		System.out.println("AAA " + ret);
		System.out.println(new Date().getTime());
	}
}
