package per.pic.test;

import per.pic.core.PicUtils;
import per.pic.model.Mat;
import per.pic.model.Operator;
import per.pic.model.PicEntity;
import per.pic.panel.PicDraw;
import per.pic.tool.ResourceUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Operator operator=new Operator(3,3,new int[]{-1,-2,-1,0,0,0,1,2,1});
            Operator operatorGs=new Operator(273,5,5,new int[]{1,4,7,4,1,4,16,26,16,4,7,26,41,26,7,4,16,26,16,4,1,4,7,4,1});
            Operator operatorLp=new Operator(3,3,new int[]{1,1,1,1,-8,1,1,1,1});

            PicEntity cpicEntity=PicUtils.getPic("D://test.jpg");
            PicDraw picDraw1=new PicDraw(cpicEntity);

            PicUtils.toBinary(cpicEntity);
            PicDraw picDraw17=new PicDraw(cpicEntity);

            PicEntity picEntity=PicUtils.getPic("D://test.jpg");
            PicUtils.toGray(picEntity);
            PicDraw picDraw2=new PicDraw(picEntity);
            Mat mat=picEntity.getPixelMat();
            mat.convolution(operatorGs);
            mat.convolution(operatorGs);
            picEntity.setPixelMat(mat);
            PicDraw picDraw3=new PicDraw(picEntity);
            PicUtils.toBinary(picEntity,123);
            PicDraw picDraw5=new PicDraw(picEntity);

            Mat mat2=picEntity.getPixelMat();
            mat2.convolution(operatorLp);
            mat2.convolution(operatorLp);
            picEntity.setPixelMat(mat2);


            PicDraw picDraw=new PicDraw(picEntity);

//            mat.convolution(operator);
//            picEntity.setPixelMat(mat);
//            PicDraw picDraw2=new PicDraw(picEntity);

//            mat.convolution(operatorGs);
//            mat.convolution(operatorGs);
//            mat.convolution(operatorGs);
//            mat.convolution(operatorGs);
//            picEntity.setPixelMat(mat);
//            PicDraw picDraw4=new PicDraw(picEntity);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
