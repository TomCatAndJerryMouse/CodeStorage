package com.ty.utils.hash;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
/**
 * MD5 hash
 * @author Administrator
 *
 */
public class HashToolTest {
	// 将用来做md5Hash字符串
	public static String soures = "password";
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		System.out.println("MD5：  " + (new HashTool(soures,HashTool.MD5,false)).digest());
		System.out.println("MD5+盐：  " + (new HashTool(soures,HashTool.MD5,true)).digest());
		System.out.println("SHA1：  " + (new HashTool(soures,HashTool.SHA1,false)).digest());
		System.out.println("SHA1+盐：  " + (new HashTool(soures,HashTool.SHA1,true)).digest());
		System.out.println("SHA256：  " + (new HashTool(soures,HashTool.SHA256,false)).digest());
		System.out.println("SHA256+盐：  " + (new HashTool(soures,HashTool.SHA256,true)).digest());
		System.out.println("SHA384：  " + (new HashTool(soures,HashTool.SHA384,false)).digest());
		System.out.println("SHA384+盐：  " + (new HashTool(soures,HashTool.SHA384,true)).digest());
		System.out.println("SHA512：  " + (new HashTool(soures,HashTool.SHA512,false)).digest());
		System.out.println("SHA512+盐：  " + (new HashTool(soures,HashTool.SHA512,true)).digest());
		System.out.println("PBKDF2：  " + (new HashTool(soures)).digestToPbkdf());
		
	}
}
