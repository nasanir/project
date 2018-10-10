package per.pic.model;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class PicEntity {
    private BufferedImage imgbuf;
    private Mat pixelMat;
    private int width;
    private int height;

    public BufferedImage getImgbuf() {
        return imgbuf;
    }

    public void setImgbuf(BufferedImage imgbuf) {
        this.imgbuf = imgbuf;
        Raster raster=imgbuf.getRaster();
        setAttribute(raster.getWidth(),raster.getHeight());
        Mat pixelMat=new Mat(raster);
        this.pixelMat=pixelMat;
    }

    private void setAttribute(int width,int height){
        this.width=width;
        this.height=height;
    }

    public Mat getPixelMat() {
        return pixelMat;
    }

    public void setPixelMat(Mat pixelMat) {
        this.pixelMat = pixelMat;
        int[] pixelArr=pixelMat.getPixelArr();
        imgbuf.getRaster().setPixels(0,0,width,height,pixelArr);
    }
}
