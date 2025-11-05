package hw6;

import java.util.Scanner;

public class Calculator {

    Scanner sc = new Scanner(System.in);
    private String x;
    private String y;

    private double result;


    public Calculator(String x, String y) throws CalException {
        double x_value;
        double y_value;

        try{
           x_value = Double.parseDouble(x);
           y_value = Double.parseDouble(y);
        }catch (NumberFormatException e){
            throw new CalException("輸入格式不正確");
        }

        if(x_value==0 && y_value==0){
            System.out.println();
            throw new CalException("不好意思，0的0次方沒有意義");
        }else if(x_value==0 && y_value<0){
            System.out.println();
            throw new CalException("不好意思，當x為0，y是負數無意義");
        }else if(x_value<0 && !checkYValue(y_value)){
            System.out.println();
            throw new CalException("不好意思，當x為負數,y為非整數涉及虛數範疇");
        }else{
            this.result = getCal(x_value,y_value);
            System.out.println();
            System.out.println("x的y次方數字為:"+getResult());
            System.out.println("---------------------");
        }

    }


	public String getX() {
        return x;
    }

    private void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    private void setY(String y) {
        this.y = y;
    }

    private boolean checkYValue(double y_value){
    	return y_value == (int)y_value;
    }

    private double getCal(double x_value , double y_value){
        return Math.pow(x_value,y_value);
    }

    public double getResult() {
        return result;
    }
}
