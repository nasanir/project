package per.pic.panel;

import per.pic.model.PicEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PicPanel extends JPanel {
    private Image image=null;
    private int width=0;
    private int height=0;

    public Image getImage() {
        return image;
    }

    public void setImage(PicEntity picEntity) {
        BufferedImage bufferedImage=picEntity.getImgbuf();
        image=bufferedImage;
        width=bufferedImage.getWidth();
        height=bufferedImage.getHeight();
        this.image = image;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paint(Graphics g){
        if(image!=null){
            g.drawImage(image,0,0,width,height,null);
        }
    }
}
