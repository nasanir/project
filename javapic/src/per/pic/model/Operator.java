package per.pic.model;

import java.util.Arrays;

public class Operator {
    private int[]    formula;
    private int[][] operator;
    private int[][] position;

    private int width;
    private int height;

    private void fillposition(int width){
        position=new int[width*width][2];

        for(int i=0;i<width*width;i++){
            position[i][0]=width-width/2+1+i%width;
            position[i][1]=width-width/2+1+i/width;
        }
    }

    public Operator(int width,int height,int[] dataArr,boolean isConvolution){
        check(width,height,dataArr);
        this.width=width;
        this.height=height;

        fillposition(width);

        formula=dataArr;
        operator=new int[width][height];
        int layer=-1;
        for(int i=0;i<dataArr.length;i++){
            if(i%width==0){
                layer++;
            }
            operator[layer][i%width]=dataArr[i];
        }

    }

    public Operator(int width,int height,int data,boolean isConvolution){
        check(width,height,null);
        this.width=width;
        this.height=height;

        fillposition(width);

        formula=new int[width*height];
        Arrays.fill(formula, data);

        this.operator=new int[width][height];
        for(int i=0;i<operator.length;i++){
            Arrays.fill(operator[i], data);
        }
    }



    private void check(int width,int height,int[] dataArr){
        if(dataArr!=null&&dataArr.length!=width*height){
            throw new RuntimeException("operator's length not equals matrix's size");
        }

        if(width*height%2==0){
            throw new RuntimeException("operator length must be odd");
        }

        if(width!=height){
            throw new RuntimeException("width must equals height");
        }
    }

    public int[] getFormula() {
        return formula;
    }

    public int[][] getOperator() {
        return operator;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getPosition() {
        return position;
    }
}
