package hw4.hw4_4;

/*
班上有8位同學，他們進行了6次考試結果如下：
請算出每位同學考最高分的次數
*/

public class hw4_4 {
    public static void main(String[] args) {
        Grade grade = new Grade();
        grade.calNumber();
        grade.printStudentGetNumber();
    }
}


class Grade{
    
    private int student_1 = 0;
    private int student_2 = 0;
    private int student_3 = 0;
    private int student_4 = 0;
    private int student_5 = 0;
    private int student_6 = 0;
    private int student_7 = 0;
    private int student_8 = 0;

    
    private int[][] g = {
        {1 ,2 ,3 , 4, 5, 6, 7, 8},
        {10,35,40,100,90,85,75,70},
        {37,75,77, 89,64,75,70,95},
        {100,70,79,90,75,70,79,90},
        {77,95,70,89,60,75,85,99},
        {98,70,89,90,75,90,89,90},
        {90,80,100,75,50,20,99,75}
    };

    public void calNumber(){
        for (int i = 1; i < g.length; i++) {
            int max = g[i][0];
            for (int j = 0; j < 8 ; j++) {
                if(max < g[i][j]){
                   max = g[i][j]; 
                }
            }
            getStudentNumber(max,i);
        }
    }
    
    private void getStudentNumber( int max , int i){
        for (int x = 0; x < g[0].length; x++) {
            if(g[i][x]==max){
                switch (x){
                    case 0:
                        student_1++;
                        break;
                    case 1:
                        student_2++;
                        break;
                    case 2:
                        student_3++;
                        break;
                    case 3:
                        student_4++;
                        break;
                    case 4:
                        student_5++;
                        break;
                    case 5:
                        student_6++;
                        break;
                    case 6:
                        student_7++;
                        break;
                    case 7:
                        student_8++;
                        break;
                }
            }
        }
    }

    public void printStudentGetNumber(){
        System.out.println("1號同學得到"+student_1+"次");
        System.out.println("2號同學得到"+student_2+"次");
        System.out.println("3號同學得到"+student_3+"次");
        System.out.println("4號同學得到"+student_4+"次");
        System.out.println("5號同學得到"+student_5+"次");
        System.out.println("6號同學得到"+student_6+"次");
        System.out.println("7號同學得到"+student_7+"次");
        System.out.println("8號同學得到"+student_8+"次");
    }
}



/* ================================ AI幫我精簡版，學習紀錄使用  =============================================== */
/*
class Grade {

    // 存 8 位學生得到最高分的次數
    private int[] count = new int[8];

    private int[][] g = {
        {1 ,2 ,3 ,4 ,5 ,6 ,7 ,8},
        {10,35,40,100,90,85,75,70},
        {37,75,77,89 ,64,75,70,95},
        {100,70,79,90 ,75,70,79,90},
        {77,95,70,89 ,60,75,85,99},
        {98,70,89,90 ,75,90,89,90},
        {90,80,100,75 ,50,20,99,75}
    };

    public void calNumber(){
        for (int i = 1; i < g.length; i++) {
            int max = g[i][0];

            // 找該次考試最高分
            for (int j = 1; j < 8; j++) {
                if (g[i][j] > max)
                    max = g[i][j];
            }

            // 找到最高分屬於哪些學生 → 累加
            for (int j = 0; j < 8; j++) {
                if (g[i][j] == max)
                    count[j]++;
            }
        }
    }

    public void printStudentGetNumber(){
        for (int i = 0; i < count.length; i++) {
            System.out.println((i+1) + "號同學得到 " + count[i] + " 次最高分");
        }
    }
}

*/
/*=========================================================================================================*/









