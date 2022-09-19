package cn.ty.util.certificate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.net.URLDecoder;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import org.junit.Test;


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
	// 密钥库类型
	private static String signCer = "sign.cer";
	// 密钥库类型
	private static String jiami = "jiami.cer";
	

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
	
	@Test
	public void sign() throws CertificateException, FileNotFoundException, NoSuchProviderException {
		String string = (this.getClass().getResource("/")+signCer).replace("file:/", "");
		String jiamiPath = (this.getClass().getResource("/")+jiami).replace("file:/", "");
		System.out.println(string);
		File signCer = new File(string);
		File jiamiCer = new File(jiamiPath);
		InputStream inStream = new FileInputStream(signCer);
		InputStream jiamiCerStream = new FileInputStream(jiamiCer);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		CertificateFactory cf = CertificateFactory.getInstance("X509","BC");
//		X509Certificate x = (X509Certificate) cf.generateCertificate(inStream);
		Certificate jiamix = cf.generateCertificate(jiamiCerStream);
		Certificate  c = cf.generateCertificate(inStream);
//		System.out.println(x.getSerialNumber());
		System.out.println(jiamix.toString());
		System.out.println(c.toString());
		
	}
	
}
