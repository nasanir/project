package per.pic.model;

import java.awt.image.Raster;
import java.util.HashMap;

public class Mat {
    private int[] pixelArr;
    private int[][][] pixelMat;
    private String matStr;

    private int width;
    private int height;
    private int numBands;

    public Mat(Raster raster) {
        pixelArr = new int[width * height * numBands];
        pixelArr = raster.getPixels(0, 0, raster.getWidth(), raster.getHeight(), pixelArr);
        setAttribute(width, height, numBands);
    }

    public Mat(int width, int height, int numBands, int[] pixelArr) {
        this.pixelArr = new int[width * height * numBands];
        for (int i = 0; i < pixelArr.length; i++) {
            this.pixelArr[i] = pixelArr[i];
        }
        setAttribute(width, height, numBands);
    }

    public Mat convolution(Operator operator) {
        int[][] positionArr = operator.getPosition();
        int[] formula = operator.getFormula();
        int[] newPixelArr = new int[pixelArr.length];

        for (int i = 0; i < pixelArr.length; i++) {
            int finalValue = 0;
            for (int j = 0; j < positionArr.length; j++) {
                int nearValue = 0;
                int position = -1;

                if (((i / numBands % width - positionArr[j][0]) >= 0 && (i / numBands % width - positionArr[j][0]) <= width)
                        && ((i / numBands / width + positionArr[j][1]) >= 0 && (i / numBands / width + positionArr[j][1]) <= pixelArr.length / numBands / width)) {
                    position = i - positionArr[j][0] * numBands + positionArr[j][1] * numBands * width;
                }

                if (position >= 0 && position < pixelArr.length) {
                    nearValue = pixelArr[position] * formula[j];
                }
                finalValue = finalValue + nearValue;
            }
            newPixelArr[i] = finalValue;
        }

        Mat pixelMat = new Mat(this.width, this.height, this.numBands, newPixelArr);
        return pixelMat;
    }

    private void setAttribute(int width, int height, int numBands) {
        this.width = width;
        this.height = height;
        this.numBands = numBands;

        pixelMat = new int[numBands][width][height];
        int bandsLayer;
        int layer = -1;
        int position = -1;

        HashMap<Integer, StringBuffer> map = getMatStringBuffer();
        for (int i = 0; i < pixelArr.length; i++) {
            bandsLayer = i % numBands;
            if (i % (numBands * width) == 0) {
                layer++;
            }
            position = (i - layer * width * numBands) / numBands;

            pixelMat[bandsLayer][layer][position] = pixelArr[i];

            StringBuffer matBf = map.get(bandsLayer);
            matBf.append(pixelArr[i]);
            if (position != 2) {
                matBf.append("-");
            } else {
                matBf.append("\n");
            }
        }

        StringBuffer matBuf = new StringBuffer((pixelArr.length / numBands * 2 + pixelArr.length / numBands / width * 2) * 3 + numBands * 4);
        for (int i = 0; i < numBands; i++) {
            matBuf.append(i).append(":").append("\n").append(map.get(i));
        }
        matStr = matBuf.toString();
    }

    private HashMap<Integer, StringBuffer> getMatStringBuffer() {
        HashMap<Integer, StringBuffer> map = new HashMap<>();
        for (int i = 0; i < numBands; i++) {
            StringBuffer bf = new StringBuffer(pixelArr.length / numBands * 2 + pixelArr.length / numBands / width * 2);
            map.put(i, bf);
        }
        return map;
    }

    public String toString() {
        return matStr;
    }

}
