package per.pic.test;

import per.pic.model.Mat;
import per.pic.model.Operator;

public class Main {

    public static void main(String[] args) {
//        try {
//            PicEntity picEntity=PicUtils.getPic("D://test.jpg");
//            PicUtils.toGray(picEntity);
//            int i=0;
//            i++;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Mat mat=new Mat(3,3,1,new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(mat.toString());

        Operator operatora=new Operator(3,3,new int[]{0,0,0,0,1,0,0,0,0});
        Operator operatorb=new Operator(3,3,1);

        Mat fa=mat.convolution(operatora);
        System.out.println(fa.toString());
        Mat fb=mat.convolution(operatorb);
        System.out.println(fb.toString());

    }
}
