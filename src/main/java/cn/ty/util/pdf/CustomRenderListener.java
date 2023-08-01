package main.java.cn.ty.util.pdf;

import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

/**
 * @Author AlphaJunS
 * @Date 12:53 2020/3/7
 * @Description pdf签名帮助类
 */
public class CustomRenderListener implements RenderListener{

    private float[] pcoordinate = null;

    private String keyWord;

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float[] getPcoordinate(){
        return pcoordinate;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

	public void beginTextBlock() {
		// TODO Auto-generated method stub
		
	}

	public void renderText(TextRenderInfo renderInfo) {
        String text = renderInfo.getText();
        if (null != text && text.contains(keyWord)) {
            Float boundingRectange = renderInfo.getBaseline().getBoundingRectange();
            pcoordinate = new float[3];
            pcoordinate[0] = boundingRectange.x;
            pcoordinate[1] = boundingRectange.y;
            pcoordinate[2] = page;
        }
		
	}

	public void endTextBlock() {
		// TODO Auto-generated method stub
		
	}

	public void renderImage(ImageRenderInfo renderInfo) {
		// TODO Auto-generated method stub
		
	}



}
