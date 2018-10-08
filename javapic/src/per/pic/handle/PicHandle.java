package per.pic.handle;

import per.pic.model.Operator;
import per.pic.model.PicEntity;
import per.pic.model.PixelMat;

public class PicHandle {

//    public PicEntity removeNoise(PicEntity picEntity){
//
//
//        return picEntity;
//    }

    public PicEntity convolution(PicEntity picEntity, Operator operator){
        int[] formula=operator.getFormula();
        int[][] position=operator.getPosition();
        int[][][] pixelMat=picEntity.getPixelMat().getPixelMat();

        for(int i=0;i<pixelMat.length;i++){
           for(int j=0;j<pixelMat[i].length;j++){
               for(int k=0;k<pixelMat[i][j].length;k++){
                    int value=0;
                    for(int t=0;t<position.length;t++){
                        int tempValue=formula[t];
                        value=value+pixelMat[i][j+position[t][0]][k+position[t][1]]*tempValue;
                    }
                   pixelMat[i][j][k]=value;
               }
           }
        }
        return null;
    }
}
