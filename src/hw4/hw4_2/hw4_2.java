package hw4.hw4_2;





/*
阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有5 個,其員工編號與身上現金列
表如下：
請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事
有錢可借他;並且統計有錢可借的總人數:例如輸入1000 就顯示「有錢可借的
員工編號: 25 19 27 共3 人!」
*/

import java.util.ArrayList;
import java.util.Scanner;

public class hw4_2 {
    public static void main(String[] args) {
        table table = new table();
        table.printWhoCan();
    }
}



class table{
    Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> canNumber;
    private int count;
    private int borrowMoney;
    private int[][] tablelist={
            {25,32,8,19,27},
            {2500,800,500,1000,1200}
    };

    public table() {
        canNumber = new ArrayList<>();
        while(true) {
            System.out.println("請輸入想要借的金額:");
            if (sc.hasNextInt()){
                this.borrowMoney = sc.nextInt();
                if(borrowMoney>=0){
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
    }

    public void printWhoCan(){
        boolean check = false;

        for (int i = 0; i <tablelist[0].length ; i++) {
                if (borrowMoney<=tablelist[1][i]) {
                    count++;
                    canNumber.add(tablelist[0][i]);
                }
        }

        if(count==0){
            check =true;
        }


        if (check) {
            System.out.println("沒有人可以借這個金額的錢QQ...");
        }else{
            System.out.print("員工編號:");
            for (int i = 0; i < canNumber.size(); i++) {
                System.out.print(i==canNumber.size()-1?canNumber.get(i):canNumber.get(i)+",");
            }
            System.out.println();
            System.out.println("總共"+count+"人可以借");
        }
    }
}
