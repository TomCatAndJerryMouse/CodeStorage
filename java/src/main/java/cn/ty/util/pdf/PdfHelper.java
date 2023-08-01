package cn.ty.util.pdf;

import com.itextpdf.text.List;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName PdfHelper
 * @Description Pdf帮助类
 * @Author AlphaJunS
 * @Date 2020/3/7 17:40
 * @Version 1.0
 */
public class PdfHelper {

    /**
     * @Author AlphaJunS
     * @Date 18:24 2020/3/7
     * @Description 用于供外部类调用获取关键字所在PDF文件坐标
     * @param filepath
     * @param keyWords
     * @return float[]
     */
    public static ArrayList<float[]> getKeyWordsByPath(String filepath, String keyWords) {
        try{
            PdfReader pdfReader = new PdfReader(filepath);
            return getKeyWords(pdfReader, keyWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author AlphaJunS
     * @Date 18:26 2020/3/7
     * @Description 获取关键字所在PDF坐标
     * @param pdfReader
     * @param keyWords
     * @return float[]
     */
    private static ArrayList<float[]> getKeyWords(PdfReader pdfReader, String keyWords) {
        
        int page = 0;
        ArrayList<float[]> list = new ArrayList<float[]>();
        try{
            int pageNum = pdfReader.getNumberOfPages();
            PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
            CustomRenderListener renderListener = new CustomRenderListener();
            renderListener.setKeyWord(keyWords);
//            for (page = 1; page <= pageNum; page++) {
                renderListener.setPage(pageNum);
                pdfReaderContentParser.processContent(1, renderListener);
                float[] coordinate = null;
                coordinate = renderListener.getPcoordinate();
                if (coordinate != null){
                	list.add(coordinate);
                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
