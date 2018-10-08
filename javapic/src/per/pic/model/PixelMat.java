package per.pic.model;

import java.awt.image.Raster;

public class PixelMat {
    private int[] pixelArr;
    private int[][][] pixelMat;

    private int width;
    private int height;
    private int numBands;

    public PixelMat(Raster raster) {
        PixelEntity pixelEntity;

        width = raster.getWidth();
        height = raster.getHeight();
        numBands = raster.getNumBands();

        pixelMat=new int[numBands][width][height];
        pixelArr = new int[width * height * numBands];
        pixelArr = raster.getPixels(0, 0, raster.getWidth(), raster.getHeight(), pixelArr);

        int bandsLayer;
        int layer=-1;
        int position=-1;
        int layerArrPosition=-1;

        for(int i=0;i<pixelArr.length;i++){
            bandsLayer=i%numBands;
            if(i%(numBands*width)==0){
                layer++;
            }
            position=(i-layer*width*numBands)/numBands;
            layerArrPosition=i%width*height;

            pixelMat[bandsLayer][layer][position]=i;
        }
    }


    public int[][][] getPixelMat() {
        return pixelMat;
    }

    public void setPixelMat(int[][][] pixelMat) {
        this.pixelMat = pixelMat;
    }

    public int[] getPixelArr() {
        return pixelArr;
    }
}
