package per.pic.test;

import per.pic.model.PicEntity;
import per.pic.tool.ResourceUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        try {
//            Operator operator=new Operator(3,3,new int[]{-1,-2,-1,0,0,0,1,2,1});
//            Operator operatorGs=new Operator(273,5,5,new int[]{1,4,7,4,1,4,16,26,16,4,7,26,41,26,7,4,16,26,16,4,1,4,7,4,1});
//
//            PicEntity cpicEntity=PicUtils.getPic("D://test.jpg");
//            PicDraw picDraw1=new PicDraw(cpicEntity);
//
//            PicUtils.toBinary(cpicEntity);
//            PicDraw picDraw17=new PicDraw(cpicEntity);
//
//            PicEntity picEntity=PicUtils.getPic("D://test.jpg");
//            PicUtils.toGray(picEntity);
//
//            Mat mat=picEntity.getPixelMat();
//            mat.convolution(operatorGs);
//            picEntity.setPixelMat(mat);
//            PicUtils.toBinary(picEntity,110);
//            PicDraw picDraw=new PicDraw(picEntity);
//
////            mat.convolution(operator);
////            picEntity.setPixelMat(mat);
////            PicDraw picDraw2=new PicDraw(picEntity);
//
////            mat.convolution(operatorGs);
////            mat.convolution(operatorGs);
////            mat.convolution(operatorGs);
////            mat.convolution(operatorGs);
////            picEntity.setPixelMat(mat);
////            PicDraw picDraw4=new PicDraw(picEntity);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
        for(int i=0;i<1000;i++){
           PicEntity picEntity=ResourceUtils.randIdCodePic();
            ResourceUtils.savePic(picEntity,"D:/test/");

        }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
