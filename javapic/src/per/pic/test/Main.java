package per.pic.test;

import per.pic.core.PicUtils;
import per.pic.model.Operator;
import per.pic.model.PicEntity;
import per.pic.panel.PicDraw;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            PicEntity picEntity=PicUtils.getPic("D://test.jpg");
            PicUtils.toGray(picEntity);
            int i=0;
            i++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
