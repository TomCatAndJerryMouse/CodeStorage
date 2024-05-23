package main.java.cn.ty.util.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * PdfFormat.java
 * <p>
 *
 * @author sunsr
 * @version 1.0
 * @since 2023/8/3 12:24
 */
public class PdfFormat {
    //原PDF文件
    public static final String PDF_SRC_FILE = "C:\\Users\\Admin\\Desktop\\new.pdf";
    //转换后的PDF文件
    public static final String PDF_DEST_FILE = "C:\\Users\\Admin\\Desktop\\new1111.pdf";;

    public static void main(String[] args) {
        try {
            // 打开源PDF文件
            PdfReader reader = new PdfReader(new FileInputStream(PDF_SRC_FILE));

            // 创建一个新的PDF文档，将源文件的内容复制到其中
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(PDF_DEST_FILE));

            // 可以在这里进行更多的格式化或编辑操作，如果需要的话

            // 关闭stamper，完成PDF的创建
            stamper.close();
            reader.close();

            System.out.println("PDF formatted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
