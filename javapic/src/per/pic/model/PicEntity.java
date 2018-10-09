package per.pic.model;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class PicEntity {
    private BufferedImage imgbuf;
    private Mat pixelMat;

    public BufferedImage getImgbuf() {
        return imgbuf;
    }

    public void setImgbuf(BufferedImage imgbuf) {
        this.imgbuf = imgbuf;
        Raster raster=imgbuf.getRaster();
        Mat pixelMat=new Mat(raster);
        this.pixelMat=pixelMat;
    }

    public Mat getPixelMat() {
        return pixelMat;
    }

    public void setPixelMat(Mat pixelMat) {
        this.pixelMat = pixelMat;
    }
}
