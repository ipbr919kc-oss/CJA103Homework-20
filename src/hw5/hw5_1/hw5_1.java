package hw5.hw5_1;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hw5_1 {
    public static void main(String[] args) {

        //問題一、
        Method_ForSquare square = new Method_ForSquare();
        square.starSquare();

        //問題二、
        Method_RandAvg randAvg = new Method_RandAvg(100);
        randAvg.randAvg();


    }
}

class Method_ForSquare{
    Scanner sc = new Scanner(System.in);
    private String width;
    private String height;
    private int WIDTH;
    private int HEIGHT;

    public Method_ForSquare() {
        validNumberCheck valid = new validNumberCheck();
        while (true) {
            System.out.println("請輸入寬度:");
            String userKeyWidth = sc.nextLine();
            if(valid.validprocess(userKeyWidth)){
                this.width = userKeyWidth;
                this.WIDTH = Integer.parseInt(this.width);
                break;
            }else {
                System.out.println("請重新輸入正整數");
                System.out.println("-----------------");
            }
        }

        while (true) {
            System.out.println("請輸入長度:");
            String userKeyHeight = sc.nextLine();
            if(valid.validprocess(userKeyHeight)){
                this.height = userKeyHeight;
                this.HEIGHT= Integer.parseInt(this.height);
                break;
            }else {
                System.out.println("請重新輸入正整數");
                System.out.println("-----------------");
            }
        }
    }

    public void starSquare(){
        System.out.println();
        System.out.println("根據您輸入的長、寬打印出來的圖形:");
        for (int i = 0; i < this.HEIGHT; i++) {
            for (int j = 0; j < this.WIDTH; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }




}

class Method_RandAvg{
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    ArrayList<Integer> haveRandomNumber = new ArrayList<>();

    private int number;



    public void randAvg(){
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(number)+1;
            if(noReplicate(r)){
                haveRandomNumber.add(r);
            }
        }
        System.out.println("本次亂數結果:");
        for (int i = 0; i <haveRandomNumber.size() ; i++) {
            System.out.print(i==haveRandomNumber.size()-1? haveRandomNumber.get(i):haveRandomNumber.get(i)+",");
            sum = sum + haveRandomNumber.get(i);
        }

        System.out.println();
        System.out.println("平均為:"+((sum*1.0)/haveRandomNumber.size()));
    }

    public Method_RandAvg(int in) {
        /*---------------------------------------
        //以下註解的部分，是讓使用者自行定義亂數產生範圍用的//

        validNumberCheck valid = new validNumberCheck();
        while (true) {
            System.out.println("請輸入一個數字");
            String userinput = sc.nextLine();
            if (valid.validprocess(userinput)) {
                this.number = Integer.parseInt(userinput);
                break;
            }else {
                System.out.println("請重新輸入正整數");
                System.out.println("-----------------");
            }
        }
        -----------------------------------------------*/
        this.number =in;

    }

    private boolean noReplicate(int need_check){
        for (int i = 0; i < haveRandomNumber.size(); i++) {
            if(need_check == haveRandomNumber.get(i)){
                return false;
            }
        }
        return true;
    }
}

/*
class MethodException extends Exception{

    public MethodException() {
    }
    public MethodException(String s) {
        super(s);
    }
}*/



class validNumberCheck{
        private double d;

    public boolean validprocess(String userKeyIn){

        try{
            d = Double.parseDouble(userKeyIn);
        } catch (Exception e) {
            System.out.println("請勿輸入文字");
            return false;
        }

        if(d<=0){
            System.out.println("請輸入大於零的數字");
            return false;
        }

        if(!(d==(int)d)){
            System.out.println("請勿輸入浮點數");
            return false;
        }else{
            return d==(int)d;
        }

    }

}