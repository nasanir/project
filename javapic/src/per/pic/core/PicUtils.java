package per.pic.core;

import per.pic.model.PicEntity;
import per.pic.panel.PicDraw;

import javax.imageio.ImageIO;
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

    public static PicEntity toGray(PicEntity picEntity){
        BufferedImage bufferedImage=picEntity.getImgbuf();
        BufferedImage graybuff=new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null).filter(bufferedImage,null);
        picEntity.setImgbuf(graybuff);
        return picEntity;
    }
}
