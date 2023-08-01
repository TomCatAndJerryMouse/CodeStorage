package main.java.cn.ty.util.path;

import java.io.File;

/**
 * ��windows��linuxϵͳ�¾�������ʹ��
 * Create by yster@foxmail.com 2018/6/6/006 14:51
 */
public class PathUtil {
    //��ȡ��Ŀ�ĸ�·��
    public final static String classPath;
 
    static {
        //��ȡ����classpath·���������ڶ�ȡresources����Դ
        classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }
 
    /**
     * ��Ŀ��Ŀ¼
     */
    public static String getRootPath() {
        return RootPath("");
    }
 
    /**
     * �Զ���׷��·��
     */
    public static String getRootPath(String u_path) {
        return RootPath("" + u_path);
    }
 
    /**
     * ˽�д�����
     */
    private static String RootPath(String u_path) {
        String rootPath = "";
        //windows��
        if ("\\".equals(File.separator)) {
            //System.out.println(classPath);
            rootPath = classPath + u_path;
            rootPath = rootPath.replaceAll("/", "\\\\");
            if (rootPath.substring(0, 1).equals("\\")) {
                rootPath = rootPath.substring(1);
            }
        }
        //linux��
        if ("/".equals(File.separator)) {
            //System.out.println(classPath);
            rootPath = classPath + u_path;
            rootPath = rootPath.replaceAll("\\\\", "/");
        }
        return rootPath;
    }
 
    //������չ�������㷢��
}
