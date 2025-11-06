package hw3.hw3_2;


//import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

/*
請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜
對則顯示正確訊息,如圖示結果:
*/
public class hw3_2{
    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.start();
    }
}

class GuessNumber{
    Scanner sc = new Scanner(System.in);
    private int rangeNumber;
    Random r = new Random();
    private int randomNumber ;


    public GuessNumber() {
        while(true) {
            System.out.println("請輸入一個大於1的正整數，以決定猜數字的範圍:");
            if (sc.hasNextInt()){
                rangeNumber = sc.nextInt();
                if(rangeNumber>1){
                    break;
                }else{
                    System.out.println("輸入錯誤，請重新輸入");
                    System.out.println("------------------");
                }
            }else {
                System.out.println("請輸入整數~~");
                sc.next();
            }
        }
        randomNumber = r.nextInt(rangeNumber)+1;
        System.out.println("您猜測數字的範圍是:1~"+rangeNumber);
        System.out.println("------開始猜數字吧!------");
    }

    public int userGuessNumber(){
        int input;
        while (true) {
            System.out.println("請輸入數字:");

            if(sc.hasNextInt()){
                input = sc.nextInt();
                if( input<1 || input>rangeNumber){
                    System.out.println("不好意思，請輸入您設定範圍1~"+rangeNumber+"內的數字");
                }else {
                    return input;
                }
            }else{
                System.out.println("不好意思，請輸入整數~~");
                sc.next();
            }
        }

    }


    public boolean checkAnswer(int input){
        if(input==randomNumber){
            return true;
        }
        return false;
    }

    public int getRandomnuber() {
        return randomNumber;
    }


    public void start(){
        while(true){
            int guess = userGuessNumber();
            if(checkAnswer(guess)){
                System.out.println("恭喜您猜對了! 答案就是:"+guess);
                break;
            }else{
                System.out.print("猜錯了");
                if(guess>getRandomnuber()){
                    System.out.println("，數字太大");
                    System.out.println("-------------");
                }else {
                    System.out.println("，數字太小");
                    System.out.println("-------------");
                }
            }
        }
    }
}
