package cn.ty.util;

import cn.hutool.core.util.HashUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 加解密工具类
 *
 * @author minghu.zhang
 * @date 15:08 2019/12/13
 **/
public class AesEncryptUtil {

    private AesEncryptUtil() {
    }

    private static AesEncryptUtil aesEncrypt = new AesEncryptUtil();

    public static AesEncryptUtil getInstance() {
        return aesEncrypt;
    }

    /**
     * 加密文本
     *
     * @param plaintext 明文文本
     * @return 密文文本
     */
    public String encrypt(String password, String plaintext) {
        try {
            if (null == plaintext || "".equals(plaintext)) {
                return plaintext;
            }
            byte[] result = getEncryptCipher(password).doFinal(StringUtils.getBytesUtf8(plaintext));
            return Base64.encodeBase64String(result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密文本
     *
     * @param plaintext 明文文本
     * @return 密文文本
     */
    public String encryptHex(String password, String plaintext) {
        try {
            if (null == plaintext || "".equals(plaintext)) {
                return plaintext;
            }
            byte[] result = getEncryptCipher(password).doFinal(StringUtils.getBytesUtf8(plaintext));
            return Hex.encodeHexString(result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密文本
     *
     * @param cipherText 密文文本
     * @return 明文文本
     */
    public String decrypt(String password, String cipherText) {
        try {
            if (null == cipherText || "".equals(cipherText)) {
                return cipherText;
            }

            byte[] bytes = Base64.decodeBase64(cipherText);
            if (bytes.length == 0) {
                throw new IllegalArgumentException("Illegal base64 character 3f");
            }
            byte[] result = getDecryptCipher(password).doFinal(bytes);
            return new String(result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密文本
     *
     * @param cipherText 密文文本
     * @return 明文文本
     */
    public String decryptHex(String password, String cipherText) {
        try {
            if (null == cipherText || "".equals(cipherText)) {
                return cipherText;
            }

            byte[] bytes = Hex.decodeHex(cipherText);
            if (bytes.length == 0) {
                throw new IllegalArgumentException("Illegal base64 character 3f");
            }
            byte[] result = getDecryptCipher(password).doFinal(bytes);
            return new String(result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密文本
     *
     * @param cipherText 密文文本
     * @return 明文文本
     */
    public String decrypt(String password, byte[] cipherText) {
        try {
            if (null == cipherText) {
                return null;
            } else {
                byte[] result = getDecryptCipher(password).doFinal(cipherText);
                return new String(result);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取加密密码器
     *
     * @return 密码器
     * @throws Exception 异常
     */
    private Cipher getEncryptCipher(String password) throws Exception {
        Cipher result = Cipher.getInstance(getType());
        result.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(createSecretKey(password), getType()));
        return result;
    }

    /**
     * 获取解密密码器
     *
     * @return 密码器
     * @throws Exception 异常
     */
    private Cipher getDecryptCipher(String password) throws Exception {
        Cipher result = Cipher.getInstance(getType());
        result.init(Cipher.DECRYPT_MODE, new SecretKeySpec(createSecretKey(password), getType()));
        return result;
    }

    /**
     * 创建密钥
     *
     * @param password 密码
     * @return 密钥字节
     */
    private byte[] createSecretKey(String password) {
        return Arrays.copyOf(DigestUtils.sha1(password), 16);
    }

    /**
     * 获取加密类型
     *
     * @return 加密类型
     */
    private String getType() {
        return "AES";
    }

    public static void main(String[] args) throws IOException {
    	int a = 1;
    	long stat = System.currentTimeMillis();
    	System.out.println(a<<30);//16 32 64
    	long end = System.currentTimeMillis();
    	System.out.println("ss1 " + (end-stat));
    	stat = System.currentTimeMillis();
    	System.out.println(a*Math.pow(2, 30));//16 32 64
    	end = System.currentTimeMillis();
    	System.out.println("ss2 " + (end-stat));
       // String pwd = "KJC9Doyx0wne9DySiNQQ0P+4hyG3Da3NqMt92DWdbKjUQMBKFa0o13/tYyw89a2p";

       // AesEncryptUtil aesEncrypt = new AesEncryptUtil();
        // 解密
      //  String pwdr = aesEncrypt.decrypt("123456", pwd);
       // System.out.println(pwdr);

       /* //加密
        String encrypt = aesEncrypt.encrypt("123456", "340102199006077971");
        System.out.println(encrypt);

        System.out.println( HashUtil.javaDefaultHash("我是谁"));
        System.out.println( HashUtil.javaDefaultHash("我是谁"));
        System.out.println( HashUtil.javaDefaultHash("我是谁1"));
        System.out.println( HashUtil.javaDefaultHash("我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2我是谁2"));
*/

        // 读取txt
        String filePath = "D:/111.txt";
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        while((strTmp = buffReader.readLine())!=null){
            String ss = "\"";
            if(strTmp.startsWith(ss)){
                strTmp = strTmp.substring(1,strTmp.length()-1);
            }
            AesEncryptUtil aesEncrypt = new AesEncryptUtil();
            // 解密
            String pwdr = aesEncrypt.decrypt("123456", strTmp);
            System.out.println(pwdr);

        }
        buffReader.close();
    }
}
