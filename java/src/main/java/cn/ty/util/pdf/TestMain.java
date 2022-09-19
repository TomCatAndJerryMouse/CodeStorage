package cn.ty.util.pdf;

import cn.ty.util.path.PathUtil;

public class TestMain {
	public static void main(String arg[]) {
    	//float [] keyword = PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("2022新三方协180号-空格问题.pdf")
    	float [] keyword = PdfHelper.getKeyWordsByPath(PathUtil.getRootPath("异常.pdf"), "新");
		for (int i=0;i<keyword.length;i++) {
			System.out.println("坐标值：" + keyword[i]);
		}
    }
}