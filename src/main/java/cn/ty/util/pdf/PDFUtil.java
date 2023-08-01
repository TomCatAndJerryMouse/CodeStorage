package main.java.cn.ty.util.pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class PDFUtil {
	public static List<KeyWordInfo> getKeyWordLocation(final String keyWords, PdfReader reader) throws IOException {
        PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(reader);
        final List<KeyWordInfo> keyWordInfoList = new ArrayList<KeyWordInfo>();
        int pageNum = reader.getNumberOfPages();
        for(int page = 1; page <= pageNum; page++ ){
            Rectangle pageSize = reader.getPageSize(page);
            final float pdfPageW = pageSize.getWidth();
            final float pdfPageH = pageSize.getHeight();
            final int finalPage = page;
            pdfReaderContentParser.processContent(page,
                    new RenderListener() {

						public void beginTextBlock() {
							// TODO Auto-generated method stub
							
						}

						public void renderText(TextRenderInfo renderInfo) {
		                      final KeyWordInfo keyWordInfo = new KeyWordInfo();
	                            keyWordInfo.setCoordinatePage(finalPage);
	                            String text = renderInfo.getText(); // 整页内容

	                            if (null != text && text.contains(keyWords)) {
	                                Rectangle2D.Float boundingRectange = renderInfo
	                                        .getBaseline().getBoundingRectange();
	                                float leftY = (float) boundingRectange.getMinY() - 1;
	                                float rightY = (float) boundingRectange.getMaxY() + 1;

	                                System.out.println(boundingRectange.x + "--"
	                                        + boundingRectange.y + "---");
	                                keyWordInfo.setHeight(rightY - leftY);
	                                keyWordInfo.setWidth((rightY - leftY)
	                                        * keyWords.length());
	                                keyWordInfo.setX(boundingRectange.x);
	                                keyWordInfo.setY(boundingRectange.y);
	                                keyWordInfo.setPageHeight(pdfPageH);
	                                keyWordInfo.setPageWidth(pdfPageW);
	                                keyWordInfoList.add(keyWordInfo);
	                            }
							
						}

						public void endTextBlock() {
							// TODO Auto-generated method stub
							
						}

						public void renderImage(ImageRenderInfo renderInfo) {
							// TODO Auto-generated method stub
							
						}
  
                    });

        }
        return keyWordInfoList;
    }
}
