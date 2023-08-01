package main.java.cn.ty.util.pdf;

import main.java.cn.ty.util.path.PathUtil;

import java.util.ArrayList;



public class TestMain {
	public static void main(String arg[]) {
		// float [] keyword =
		// PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("2022新三方协180号-空格问题.pdf")
		// float [] keyword =
		// PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("交易通远程异地测试02.pdf"),
		// "评标委员会成员签字:");
		ArrayList<float[]> keywords = PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("正常.pdf"), "公司");
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
	}}
}