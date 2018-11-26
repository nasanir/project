package per.pic.panel;

import per.pic.model.PicEntity;

import javax.swing.*;

public class PicDraw extends JFrame {
    private PicPanel picPanel=null;
    private int width=150;
    private int height=150;


    public PicDraw(PicEntity picEntity){
        picPanel=new PicPanel();
        picPanel.setImage(picEntity);
        width=picPanel.getWidth()>150?picPanel.getWidth():width;
        height=picPanel.getHeight()>150?picPanel.getHeight():height;
        this.add(picPanel);
        this.setSize(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
