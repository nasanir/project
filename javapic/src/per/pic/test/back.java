package per.pic.test;

import per.pic.model.PicEntity;
import per.pic.tool.ResourceUtils;

import java.io.IOException;

public class back {

    public void back(){
        try {
            for(int i=0;i<100;i++){
                PicEntity picEntity=ResourceUtils.randIdCodePic();
                ResourceUtils.savePic(picEntity,"D:/test/");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
