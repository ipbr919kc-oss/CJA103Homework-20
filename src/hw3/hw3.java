package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class hw3 {
	public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("請輸入三個整數");
        int n1= sc.nextInt();
        int n2= sc.nextInt();
        int n3= sc.nextInt();

        triangle triangle = new triangle(n1,n2,n3);
        System.out.println(triangle.checkType());
    }
}



class triangle{

    private int side1;
    private int side2;
    private int side3;
    private int[] sidedata;
    
    triangle(int side1, int side2, int side3){
        sidedata = order(side1,side2,side3);
        this.side1=sidedata[0];
        this.side2=sidedata[1];
        this.side3=sidedata[2];
    }


    public String checkType(){

        if(side1 >0 && side2 >0 && side3 >0 && (side1+side2>side3) ){
            if(side1==side2 && side2==side3){
                return "此為正三角形";
            } else if (side1==side2 || side2==side3 || side3==side1){
               /* if(rightTriangleTest(side1,side2,side3)){
                    return "此為等腰直角三角形";
                }*/
                return "此為等腰三角形";
            } else if(rightTriangleTest(side1,side2,side3)){
                return"此為直角三角形";
            }else {
                return "此為其他三角形";
            }
        }
        return "此三角形不存在";
    }


    private boolean rightTriangleTest (int a, int b, int c){
        if(c*c==(a*a+b*b)){
            return true;
        }
        return false;
    }

    private int[] order(int a, int b, int c){
        int[] sidedata = {a,b,c};
        Arrays.sort(sidedata);
        return sidedata;
    }

}