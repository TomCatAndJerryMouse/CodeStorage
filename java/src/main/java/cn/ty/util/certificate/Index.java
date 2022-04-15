package cn.ty.util.certificate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

import com.sun.xml.internal.ws.util.StringUtils;

public class Index {
	// 密钥库密码
	private static String storepass = "123123";
	// 证书库路径
	private static String storePath = Index.class.getResource("").toString().replace("file:/", "") + "mytest.keystore";
	// 证书别名
	private static String certAlias  = "mytest";
	// 密钥库类型
	private static String keyType = "JKS";
	
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException, InvalidKeyException {
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
		Signature sig = Signature.getInstance("SHA1withDSA");
		sig.initSign(priKey);
	}
}
