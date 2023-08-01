package cn.ty.util.hash;


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
		System.out.println("MD5：  " + (new HashTool(soures,HashTool.MD5)).digest());
		System.out.println("MD5+盐：  " + (new HashTool(soures,HashTool.MD5,HashTool.getSalt())).digest());
		System.out.println("SHA1：  " + (new HashTool(soures,HashTool.SHA1)).digest());
		System.out.println("SHA1+盐：  " + (new HashTool(soures,HashTool.SHA1,HashTool.getSalt())).digest());
		System.out.println("SHA256：  " + (new HashTool(soures,HashTool.SHA256)).digest());
		System.out.println("SHA256+盐：  " + (new HashTool(soures,HashTool.SHA256,HashTool.getSalt())).digest());
		System.out.println("SHA384：  " + (new HashTool(soures,HashTool.SHA384)).digest());
		System.out.println("SHA384+盐：  " + (new HashTool(soures,HashTool.SHA384,HashTool.getSalt())).digest());
		System.out.println("SHA512：  " + (new HashTool(soures,HashTool.SHA512)).digest());
		System.out.println("SHA512+盐：  " + (new HashTool(soures,HashTool.SHA512,HashTool.getSalt())).digest());
		System.out.println("PBKDF2：  " + (new HashTool(soures)).digestToPbkdf());
		
	}
}
