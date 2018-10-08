package per.pic.model;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class PicEntity {
    private BufferedImage imgbuf;
    private PixelMat pixelMat;

    public BufferedImage getImgbuf() {
        return imgbuf;
    }

    public void setImgbuf(BufferedImage imgbuf) {
        this.imgbuf = imgbuf;
        Raster raster=imgbuf.getRaster();
        PixelMat pixelMat=new PixelMat(raster);
        this.pixelMat=pixelMat;
    }

    public PixelMat getPixelMat() {
        return pixelMat;
    }

    public void setPixelMat(PixelMat pixelMat) {
        this.pixelMat = pixelMat;
    }
}
