package per.pic.test;

import per.pic.core.PicUtils;
import per.pic.model.Mat;
import per.pic.model.Operator;
import per.pic.model.PicEntity;
import per.pic.panel.PicDraw;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public class MainTest {

    public static void main(String[] args) {
        String expression = "MAX({A},{B})+A*MAX({A},{B})+MIN({B},{C})";
        HashMap<String,BigDecimal> valueMap=new HashMap<>();
        valueMap.put("A",new BigDecimal(1));
        valueMap.put("B",new BigDecimal(3));
        valueMap.put("C",new BigDecimal(5));

        int maxCout = expression.split("MAX").length - 1;
        int minCount = expression.split("MIN").length - 1;
        int count = maxCout > minCount ? maxCout : minCount;

        for (int i = 0; i < count; i++) {
            BigDecimal maxValue = null;
            BigDecimal minValue = null;

            String maxNum = "";
            String minNum = "";
            for (String key : valueMap.keySet()) {
                if (valueMap.get(key) != null) {
                    BigDecimal value = valueMap.get(key);
                    int startMax = expression.indexOf("MAX(");
                    int endMax = expression.indexOf(")", startMax);

                    int startMin = expression.indexOf("MIN(");
                    int endMin = expression.indexOf(")", startMin);

                    if (startMax >= 0 && endMax > 0) {
                        maxNum = expression.substring(startMax, endMax + 1);
                    }
                    if (startMin >= 0 && endMin > 0) {
                        minNum = expression.substring(startMin, endMin + 1);
                    }

                    if (maxNum.contains(key) && (maxValue == null || value.compareTo(maxValue) > 0)) {
                        maxValue = value;
                    }

                    if (minNum.contains(key) && (minValue == null || value.compareTo(minValue) < 0)) {
                        minValue = value;
                    }
                }
            }
            expression = expression.replace(maxNum, maxValue.toString()).replace(minNum, minValue.toString());
        }
        expression=expression;
//        try {
//            Operator operator=new Operator(3,3,new int[]{-1,-2,-1,0,0,0,1,2,1});
//            Operator operatorGs=new Operator(273,5,5,new int[]{1,4,7,4,1,4,16,26,16,4,7,26,41,26,7,4,16,26,16,4,1,4,7,4,1});
//            Operator operatorLp=new Operator(3,3,new int[]{1,1,1,1,-8,1,1,1,1});
//
//            PicEntity picEntity=PicUtils.getPic("D://test3.jpg");
//            PicUtils.toGray(picEntity);
//            Mat mat=picEntity.getPixelMat();
//            mat.convolution(operatorLp);
//
//            picEntity.setPixelMat(mat);
//            PicDraw picDraw3=new PicDraw(picEntity);
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

    }
}
