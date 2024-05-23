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
		System.out.println(Index.class.getClassLoader().getResource(""));
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
//		cf.getPublicKey()
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
		System.out.println("签名值===============："+ss);


		sig.initVerify(cf.getPublicKey());
		sig.update("123123".getBytes());
		System.out.println("验证签名结果===========================："+sig.verify(Base64.getDecoder().decode(ss)));
		System.out.println("签名值===============："+ss);
	}
	
	@Test
	public void sign() throws CertificateException, FileNotFoundException, NoSuchProviderException {
		String string = (this.getClass().getResource("/")+signCer).replace("file:/", "");
		String jiamiPath = (this.getClass().getResource("/")+jiami).replace("file:/", "");
		String xx12312 = (this.getClass().getResource("/")+"12312.cer").replace("file:/", "");
		System.out.println(string);
		File signCer = new File(string);
		File jiamiCer = new File(jiamiPath);
		File xx12312Cer = new File(xx12312);
		InputStream inStream = new FileInputStream(signCer);
		InputStream jiamiCerStream = new FileInputStream(jiamiCer);
		InputStream xx12312CerCerStream = new FileInputStream(xx12312Cer);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		CertificateFactory cf = CertificateFactory.getInstance("X509","BC");
//		X509Certificate x = (X509Certificate) cf.generateCertificate(inStream);
		Certificate jiamix = cf.generateCertificate(jiamiCerStream);
		Certificate  c = cf.generateCertificate(inStream);
		Certificate  c1 = cf.generateCertificate(xx12312CerCerStream);
//		System.out.println(x.getSerialNumber());
		System.out.println(jiamix.toString());
		System.out.println(c.toString());
		System.out.println(c1.toString());
		
	}

	/**
	 * 使用cer验签
	 */
	@Test
	public void verfiy()throws CertificateException, FileNotFoundException, NoSuchProviderException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException, InvalidKeyException, SignatureException {
//		System.out.println(Base64.getDecoder().decode("ae3TVoXrV9sxwYj6EiFjUvtpEUqAlwEI1tGVrSeyWpcM8A2pHqb0J+JDvK+9OiAkVSRnbtn5otVZuqTX72vmu0gDKFBcjKGAuHKEBxaJD09ggwqKBiGPJwkt5tNP7EBu7zOwTnZq1SOE0aIv9m1+1Q3a5XsKabF0OIDRHVhKMAz1id6tYnLv2QnpCi66d+QuQRbwzMY5YKP1sIAu4aEaYdVVW8/wuCdVJpg4blYzwrxN522dWExa6s5eAmhJE2ukckXMvgz6K9TyPovCRx80hhAJTNw/fn6tuGtuLO1VejUEIrETL0QcAc6hIVNGN33+kZVONB/mqh5h6S9+WsOyPg=="));
		String xx12312 = (this.getClass().getResource("/")+"wangweilie.cer").replace("file:/", "");
		System.out.println(xx12312);
		File xx12312Cer = new File(xx12312);
		InputStream xx12312CerCerStream = new FileInputStream(xx12312Cer);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		CertificateFactory cf = CertificateFactory.getInstance("X509","BC");
		Certificate  c1 = cf.generateCertificate(xx12312CerCerStream);
		// 打印证书信息
		//System.out.println(c1.toString());
		// 用私钥签名
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initVerify(c1.getPublicKey());
		sig.update("代付类型:721C516A-2829-4476-9A8C-42DB066B63A1^货币编号:RMB^应付金额:9600.00^付款账户内码:0000000360^结算方式:1111^出纳:王列线^摘要:党风廉政先进集体^对方账号:6228482928708101571^对方户名:段伟峰^付款金额:84dkxynz0IZ1vQ7tBUEp2BnHyFRY/XoQCR9O1L8XKmE=^对方账号:6228482928367875671^对方户名:王鹏华^付款金额:84dkxynz0IZ1vQ7tBUEp2BnHyFRY/XoQCR9O1L8XKmE=^对方账号:6228482921042485511^对方户名:刘玉龙^付款金额:pkfZ83avaVXhDaG8HS+Qu2fN07+fuOnPdUz6of8ckvI=^对方账号:6228482920952282918^对方户名:肖年成^付款金额:pkfZ83avaVXhDaG8HS+Qu2fN07+fuOnPdUz6of8ckvI=^对方账号:6228482921042470315^对方户名:陶振义^付款金额:pkfZ83avaVXhDaG8HS+Qu2fN07+fuOnPdUz6of8ckvI=^对方账号:6228482928327669677^对方户名:王飞^付款金额:84dkxynz0IZ1vQ7tBUEp2BnHyFRY/XoQCR9O1L8XKmE=^对方账号:6228482928718174071^对方户名:倪凯峰^付款金额:84dkxynz0IZ1vQ7tBUEp2BnHyFRY/XoQCR9O1L8XKmE=^对方账号:6228482928685135477^对方户名:赵磊^付款金额:pkfZ83avaVXhDaG8HS+Qu2fN07+fuOnPdUz6of8ckvI=^对方账号:6228482928694550476^对方户名:白杨明^付款金额:pkfZ83avaVXhDaG8HS+Qu2fN07+fuOnPdUz6of8ckvI=^对方账号:6228482920646192010^对方户名:贺刘军^付款金额:pkfZ83avaVXhDaG8HS+Qu2fN07+fuOnPdUz6of8ckvI=".getBytes());
		System.out.println("验证签名结果===========================："+sig.verify(Base64.getDecoder().decode("ae3TVoXrV9sxwYj6EiFjUvtpEUqAlwEI1tGVrSeyWpcM8A2pHqb0J+JDvK+9OiAkVSRnbtn5otVZuqTX72vmu0gDKFBcjKGAuHKEBxaJD09ggwqKBiGPJwkt5tNP7EBu7zOwTnZq1SOE0aIv9m1+1Q3a5XsKabF0OIDRHVhKMAz1id6tYnLv2QnpCi66d+QuQRbwzMY5YKP1sIAu4aEaYdVVW8/wuCdVJpg4blYzwrxN522dWExa6s5eAmhJE2ukckXMvgz6K9TyPovCRx80hhAJTNw/fn6tuGtuLO1VejUEIrETL0QcAc6hIVNGN33+kZVONB/mqh5h6S9+WsOyPg==")));
	}
	
}
