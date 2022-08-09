package cn.ty.util.certificate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

public class Index {
	// 密钥库密码
	private static String storepass = "123123";
	// 证书库路径
	//private static String storePath = Index.class.getResource("").toString().replace("file:/", "") + "mytest.keystore";
	private static String storePath = "";
	// 证书别名
	private static String certAlias  = "mytest";
	// 密钥库类型
	private static String keyType = "JKS";

	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException, InvalidKeyException, SignatureException {
		storePath = URLDecoder.decode(Index.class.getClassLoader().getResource("mytest.keystore").getPath().toString(),"UTF-8");
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			storePath = storePath.substring(1);
		}
		System.out.println(storePath);
		// 
		FileInputStream fi = new FileInputStream(storePath);
		// 初始化密钥库 
		KeyStore ks = KeyStore.getInstance(keyType);
		ks.load(fi,storepass.toCharArray());
		// 获取证书
		Certificate cf = ks.getCertificate(certAlias);

		System.out.println(Base64.getEncoder().encodeToString(cf.getEncoded()));
//		ks.getCertificate(alias);
		
		// 获取私钥
		PrivateKey priKey = (PrivateKey)ks.getKey(certAlias,storepass.toCharArray());
		System.out.println(Base64.getEncoder().encodeToString(priKey.getEncoded()));
		
		// 用私钥签名
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initSign(priKey);
		sig.update("123123".getBytes());
		String ss = Base64.getEncoder().encodeToString(sig.sign());
		System.out.println("签名值："+ss);


		sig.initVerify(cf.getPublicKey());
		sig.update("123123".getBytes());
		System.out.println("验证签名结果："+sig.verify(Base64.getDecoder().decode(ss)));
	}
}
