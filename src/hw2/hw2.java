package hw2;

public class hw2 {
	public static void main(String[] args) {
		Question1 q1 = new Question1();
        q1.calculate1(1000);
        q1.calculate_for(10);
        q1.calculate_while(10);
        q1.power(100);

    Question2 q2 = new Question2();
        q2.lotto(49);
        q2.pinrtShape(10);

    Question3 q3 = new Question3();
        q3.printLetter('F');
	}
}	

	class Question1{
		// 請設計一隻Java程式，計算1～1000的偶數和(2+4+6+8+…+1000)
		   public void calculate1(int n){
		       int sum1=0;
		       for (int i=0 ; i <= n ; i++ ){
		           if(i%2!=0){
		               continue;
		           }
		           sum1 = sum1 +i ;
		       }
		       System.out.println("所有偶數和:"+ sum1);
		       System.out.println("----------------");
		   }

		//請設計一隻Java程式，計算1～10的連乘積(1*2*3*…*10) (用for迴圈)
		    public void calculate_for(int n){
		       int sum2=1;
		        for (int i = 1; i <= n ; i++) {
		            sum2*=i;
		        }
		        System.out.print("for迴圈");
		        System.out.println("1～"+n+"的連乘積:"+sum2);
		        System.out.println("----------------");
		    }

		// 請設計一隻Java程式，計算1～10的連乘積(1*2*3*…*10) (用while迴圈)
		    public void calculate_while(int n){
		        int sum3=1;
		        int i=1;
		        while(i<(n+1)){
		            sum3*=i;
		            i++;
		        }
		        System.out.print("while迴圈");
		        System.out.println("1～"+n+"的連乘積:"+sum3);
		        System.out.println("----------------");
		    }

		// 請設計一隻Java程式，輸出結果為以下： 1 4 9 16 25 36 49 64 81 100
		    public void power(int n){
		       System.out.println("1～"+n+"開根號為正整數者:");
		       for (int i = 1; i <=n; i++) {
		            int pi = (int)Math.sqrt(i);
		            if(pi*pi == i){
		                System.out.print(i==n?i:i+",");
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
		    public void lotto(int n) {
		        int validnumber = 0;
		        for (int i = 1; i <= n; i++) {
		            String s = String.valueOf(i);
		            if (!s.contains("4")) {
		                validnumber++;
		            }
		        }
		        int validnumber2 =0;
		        System.out.println("阿文可以選擇的數字有:");
		        for (int i = 1; i <= n; i++) {
		            String check = String.valueOf(i);
		            if (!check.contains("4")) {
		                validnumber2++;
		                if (validnumber2 == validnumber) {
		                    System.out.println(i);
		                } else {
		                    System.out.print(i + ",");
		                }
		            }
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
		*/  
		    public void pinrtShape(int n){
		        System.out.println("數字打印:");
		        for (int i = n; 1 <= i ; i--) {
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
		    public void printLetter(char ch){
		        System.out.println("字母打印:");
		        for (int i = 65 ; i <= ((int)ch); i++) {
		            int c=0;
		            for (int j = i; c<=(i-65) ;c++) {
		                System.out.print((char)j);
		            }
		            System.out.println();
		        }
		    }
		}
	