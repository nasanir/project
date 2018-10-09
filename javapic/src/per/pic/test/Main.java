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
        Mat mat=new Mat(3,3,3,new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(mat.toString());

    }
}
