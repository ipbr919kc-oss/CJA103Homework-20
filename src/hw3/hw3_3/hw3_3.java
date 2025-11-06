package hw3.hw3_3;

/*
阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇
的號碼與總數,如圖:
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hw3_3 {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.start(lotto.choice());
    }
}

class Lotto{
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    private int hateNumber;
    private int count;

    private ArrayList<Integer> userNumber = new ArrayList<>();
    private int[] userGetNumber = new int[6];
    private ArrayList<Integer> userKeyIn = new ArrayList<>();


    /*
     //原本寫了一個方法(但不成功)，後來改完放放在建構子。以下紀錄失敗過程:
			public void printShape(String hateNumber){
        //自己打的失敗原稿---------------------------------------------------
            
                int count=0;
                for (int i = 0; i < 7; i++) {
                    int c = 1;
                    c= c * i;
                    for (int j = 1+(c*7); j <1+(c*7)+7 ; j++) {
                        String s = String.valueOf(j);
                        if (s.contains(hateNumber)) {
                            continue;
                        }else{
                            System.out.print(j+"\t");
                            count++;
                        }
                    }
                    System.out.println();
                }
                System.out.println("總共有:"+count+"數字可以選擇。");
            
        //----------------------------------------------------------------
        //GPT建議寫法:
		    	for (int i = 1; i <=49 ; i++) {
		            
		            String s= String.valueOf(i);
		            
		            if(s.contains(hateNumber)){
		                continue;
		            }
		            System.out.print(i+"\t");
		            count++;
		            
		            if(count%7==0){
		                System.out.println();
		            }
		        }
		        System.out.println();
		        System.out.println("總共"+count+"個數字可以選擇!");
			}
     */

    public Lotto() {
        System.out.println("======歡迎您開始選擇樂透號碼，數字大小:\"1~49\"之間==========");

        while(true) {
            System.out.println("阿文，請輸入您討厭的數字(數字1-9)，我將為您排除並列出你能選的數字:");
            if (sc.hasNextInt()){
                this.hateNumber = sc.nextInt();
                if(hateNumber>0 && hateNumber<10 ){
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
        System.out.println("已經幫您排除1~49所有包含"+"\""+hateNumber+"\""+"的數字!");
        System.out.println("====以下是您能選的數字表，請參考=========");

        for (int i = 1; i <=49 ; i++) {
            String s= String.valueOf(i);
            if(s.contains(String.valueOf(hateNumber))){
                continue;
            }

            System.out.print(i+"\t");
            count++;
            userNumber.add(i);

            if(count%7==0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("您尚有"+count+"個數字可以選擇!");
    }

    public String getHateNumber() {
        return String.valueOf(hateNumber);
    }


    public void randomNumber(){
        for (int i = 0; i < 6; i++) {
            while (true) {
                int random_index = random.nextInt(count);
                int num = userNumber.get(random_index);
                if (checkForRandom(num)) {
                    userGetNumber[i] =num;
                    break;
                }
            }
        }

        System.out.print("您隨機選到的數字為:");
        for (int i = 0; i < userGetNumber.length; i++) {
            System.out.print(i==5?userGetNumber[i]:userGetNumber[i]+",");
        }
        System.out.println();
        System.out.println("-------------------");

    }


    public int choice(){
        System.out.println("請問是否需要幫您隨機亂數挑選6組數字?");
        System.out.println("是的話請輸入數字\"1\"，若想手動輸入數字的話請先輸入數字\"0\"");
        while(true) {
            if (sc.hasNextInt()){
                int input_check = sc.nextInt();
                if( input_check==1 || input_check==0 ){
                    return input_check;
                }else{
                    System.out.println("輸入不正確，請重新輸入");
                    System.out.println("------------------");
                }
            }else {
                System.out.println("請輸入正確的整數~~");
                sc.next();
            }
        }
    }

    public void start(int input_check){
        switch (input_check){
            case 0:
                checkInput();
                return;
            case 1:
                randomNumber();
                return;
            default:
                System.out.println("拜託別跑到這裡...");
        }
    }

    public boolean checkForRandom(int num){
        for (int i = 0; i < userGetNumber.length; i++) {
            if(num==userGetNumber[i]){
                return false;
            }
        }
        return true;
    }

    public void checkInput(){
        int count=0;
        System.out.println("請輸入您想要的六個數字:");
        while(count<6) {
            if (sc.hasNextInt()){
                int num = sc.nextInt();
                if (1<=num && num<=49) {
                    if(checkForKeyIn(num)){
                        userKeyIn.add(num);
                        count++;
                    }else{
                        System.out.println("此數字:"+"\""+num+"\""+"可能有數字重複或被排除的情形，請重新輸入數字:");
                        System.out.println("------------------");
                    }
                }else{
                    System.out.println("不好意思，請重新輸入1~49範圍內的數字");
                }

            }else {
                System.out.println("請輸入整數~~");
                sc.next();
            }
        }

        System.out.print("您選得六個數字為:");
        for (int i = 0; i < userKeyIn.size(); i++) {
            System.out.print(i==userKeyIn.size()-1?userKeyIn.get(i):userKeyIn.get(i)+",");
        }
        System.out.println();
        System.out.println("-------------------");



    }

    public boolean checkForKeyIn(int num){
        for (int i = 0; i < userKeyIn.size(); i++) {
            if(num==userKeyIn.get(i)){
                System.out.println("已有重複數字");
                return false;
            }
        }
        for (int i = 0; i <userNumber.size() ; i++) {
            if(num==userNumber.get(i)){
                return true;
            }
        }
        return false;
    }







}