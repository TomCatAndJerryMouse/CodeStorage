package cn.ty.util.pdf;

import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import main.java.cn.ty.util.path.PathUtil;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.ArrayList;


public class TestMain {
	public static void main(String arg[]) {
//		getKeyWords(	);
		sign();

	}

	public static void getKeyWords() {
		// float [] keyword =
		// PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("2022新三方协180号-空格问题.pdf")
		// float [] keyword =
		// PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("交易通远程异地测试02.pdf"),
		// "评标委员会成员签字:");
//		ArrayList<float[]> keywords = PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("异常.pdf"), "公司");
		ArrayList<float[]> keywords = PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("new.pdf"), "交");

		if (null != keywords) {
			for (float[] keyword : keywords) {
				for (int i = 0; i < keyword.length; i++) {
					switch (i) {
						case 0:
							System.out.println("横坐标值：" + keyword[i]);
							break;
						case 1:
							System.out.println("纵坐标值：" + keyword[i]);
							break;
						case 2:
							System.out.println("页码值：" + keyword[i]);
							break;
					}
				}
				System.out.println();
			}
			System.out.println("找到匹配关键字数目：" + keywords.size());
		}
	}

	public static void sign(){
		try {
//			ItextUtil app = new ItextUtil();
			// 将证书文件放入指定路径，并读取keystore ，获得私钥和证书链
			String pkPath = PathUtil.getRootPath("mytest.keystore");
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(new FileInputStream(pkPath), "123123".toCharArray());
			String alias = ks.aliases().nextElement();
			PrivateKey pk = (PrivateKey) ks.getKey(alias, "123123".toCharArray());
			// 得到证书链
			Certificate[] chain = ks.getCertificateChain(alias);
			//需要进行签章的pdf
			String path = PathUtil.getRootPath("new.pdf");
			// 封装签章信息
			SignatureInfo signInfo = new SignatureInfo();
			signInfo.setReason("理由");
			signInfo.setLocation("位置");
			signInfo.setPk(pk);
			signInfo.setChain(chain);
			signInfo.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
			signInfo.setDigestAlgorithm(DigestAlgorithms.SHA1);
			signInfo.setFieldName("demo");

			// 签章图片
			signInfo.setImagePath( PathUtil.getRootPath("chapter.png"));
			signInfo.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
			//值越大，代表向x轴坐标平移 缩小 （反之，值越小，印章会放大）
			signInfo.setRectllx(100);
			//值越大，代表向y轴坐标向上平移（大小不变）
			signInfo.setRectlly(200);
			// 值越大   代表向x轴坐标向右平移  （大小不变）
			signInfo.setRecturx(150);
			// 值越大，代表向y轴坐标向上平移（大小不变）
			signInfo.setRectury(150);
			//签章后的pdf路径
			PdfHelper.sign(path, "C:\\Users\\Admin\\Desktop\\new35.pdf", signInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}