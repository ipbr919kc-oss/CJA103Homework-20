package hw2;

public class hw2 {
	public static void main(String[] args) {
        //建立問題一物件
        Question1 q1 = new Question1();
            q1.calculate1_100();
            q1.calculate_for10();
            q1.calculate_while10();
            q1.power();
        //建立問題二物件
        Question2 q2 = new Question2();
            q2.lotto();
            q2.pinrtShape();
        //建立問題三物件
        Question3 q3 = new Question3();
            q3.printLetter();
    }
}

class Question1{
	// 請設計一隻Java程式，計算1～1000的偶數和(2+4+6+8+…+1000)
	   public void calculate1_100(){
	       int sum1=0;
	       for (int i=0 ; i <= 1000 ; i++ ){
	           if(i%2!=0){
	               continue;
	           }
	           sum1 = sum1 +i ;
	       }
	       System.out.println("所有偶數和:"+ sum1);
	       System.out.println("----------------");
	   }

	//請設計一隻Java程式，計算1～10的連乘積(1*2*3*…*10) (用for迴圈)
	    public void calculate_for10(){
	       int sum2=0;
	        for (int i = 1; i < 11 ; i++) {
	            sum2*=i;
	        }
	        System.out.print("for迴圈");
	        System.out.println("1～10的連乘積:"+sum2);
	        System.out.println("----------------");
	    }

	// 請設計一隻Java程式，計算1～10的連乘積(1*2*3*…*10) (用while迴圈)
	    public void calculate_while10(){
	        int sum3=0;
	        int i=1;
	        while(i<11){
	            sum3*=i;
	            i++;
	        }
	        System.out.print("while迴圈");
	        System.out.println("1～10的連乘積:"+sum3);
	        System.out.println("----------------");
	    }

	// 請設計一隻Java程式，輸出結果為以下： 1 4 9 16 25 36 49 64 81 100
	    public void power(){
	       System.out.println("1-100開根號為正整數者:");
	       for (int i = 1; i < 101; i++) {
	            int pi = (int)Math.sqrt(i);
	            if(pi*pi == i){
	                System.out.print(i==100?i:i+",");
	            }
	        }
	        System.out.println();
	        System.out.println("----------------");
	    }

	}

class Question2{
	/*
	    阿文很熱衷大樂透(1 ～49)，但他不喜歡有4的數字，不論是個位數或是十位數。請設計一隻程式，
	    輸出結果為阿文可以選擇的數字有哪些？總共有幾個？
	*/
	    public void lotto() {
	        System.out.println("阿文可以選擇的數字有:");
	        for (int i = 1; i < 50; i++) {
	            String check = String.valueOf(i);
	            if (check.contains("4")) {
	                continue;
	            }
	            System.out.print(i==39?i:i+",");
	        }
	        System.out.println();
	        System.out.println("----------------");
	    }
	/*
	    請設計一隻Java程式，輸出結果為以下：
	    1 2 3 4 5 6 7 8 9 10
	    1 2 3 4 5 6 7 8 9
	    1 2 3 4 5 6 7 8
	    1 2 3 4 5 6 7
	    1 2 3 4 5 6
	    1 2 3 4 5
	    1 2 3 4
	    1 2 3
	    1 2
	    1
	*/  public void pinrtShape(){
	        System.out.println("數字打印:");
	        for (int i = 10; 1 <= i ; i--) {
	            for (int j = 1; j <=i ; j++) {
	                System.out.print(j+" ");
	            }
	            System.out.println();
	        }
	        System.out.println("----------------");
	    }
	}

class Question3{
	/*
	    請設計一隻Java程式，輸出結果為以下：
	    A
	    BB
	    CCC
	    DDDD
	    EEEEE
	    FFFFFF
	*/
	    public void printLetter(){
	        System.out.println("字母打印:");
	        for (int i = 65; i < 71; i++) {
	            int c=0;
	            for (int j = i; c<=(i-65) ;c++) {
	                System.out.print((char)j);
	            }
	            System.out.println();
	        }
	    }
	}
