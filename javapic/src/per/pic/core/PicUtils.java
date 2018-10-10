package per.pic.core;

import per.pic.model.Mat;
import per.pic.model.PicEntity;
import per.pic.panel.PicDraw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PicUtils {
    public static PicEntity getPic(String path) throws IOException {
        FileInputStream fis=new FileInputStream(new File(path));
        BufferedImage bufferedImage=ImageIO.read(fis);
        PicEntity picEntity=new PicEntity();
        picEntity.setImgbuf(bufferedImage);
        return picEntity;
    }

    public static void toGray(PicEntity picEntity){
        BufferedImage bufferedImage=picEntity.getImgbuf();
        BufferedImage graybuff=new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null).filter(bufferedImage,null);
        picEntity.setImgbuf(graybuff);
    }

    public static void toBinary(PicEntity picEntity,int threshold){
        if(threshold<0||threshold>255){
            throw new RuntimeException("threshold must between 0-255");
        }
        toGray(picEntity);
        Mat picMat=picEntity.getPixelMat();
        int[] pixelArr=picMat.getPixelArr();
        for(int i=0;i<pixelArr.length;i++){
            int pixelValue=pixelArr[i];
            if(pixelValue<=threshold){
                pixelArr[i]=0;
            }else{
                pixelArr[i]=255;
            }
        }
        picEntity.setPixelMat(picMat);
    }

    public static void toBinary(PicEntity picEntity){
        toBinary(picEntity,130);
    }
}
