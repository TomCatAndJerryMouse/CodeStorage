package main.java.cn.ty.util.pdf;

public class KeyWordInfo {
    private float x;//在pdf的x坐标
    private float y;//在pdf的y坐标
    private double width;//关键字的宽度
    private double height;//关键字高度
    private int coordinatePage ;//关键字所在页
    private float pageWidth ;//关键字所在页宽度
    private float pageHeight ;//关键字所在页高度
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCoordinatePage() {
        return coordinatePage;
    }

    public void setCoordinatePage(int coordinatePage) {
        this.coordinatePage = coordinatePage;
    }

    public KeyWordInfo(float x, float y, int coordinatePage) {
        this.x = x;
        this.y = y;
        this.coordinatePage = coordinatePage;
    }

    public float getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(float pageWidth) {
        this.pageWidth = pageWidth;
    }

    public float getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(float pageHeight) {
        this.pageHeight = pageHeight;
    }

    public KeyWordInfo() {
    }

    @Override
    public String toString() {
        return "KeyWordInfo{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", coordinatePage=" + coordinatePage +
                '}';
    }
}