package hw5.hw5_2;

public class hw5_2 {
    public static void main(String[] args) {
        int[][] intArray = {
                {1,6,3},
                {9,5,2}
        };
        double[][] doubleArray = {
                {1.2,3.5,2.2},
                {7.4,2.1,8.2}
        };

        FindMax findMax = new FindMax();
        System.out.println("intArray最大值為:"+findMax.maxElemant(intArray));
        System.out.println("doubleArray最大值為:"+findMax.maxElemant(doubleArray));
    }

}


class FindMax{

    public int maxElemant(int[][] intmax){
        int max = intmax[0][0];
        for (int i = 0; i <intmax.length ; i++) {
            for (int j = 0; j <intmax[i].length ; j++) {
                if(max<intmax[i][j]){
                    max = intmax[i][j];
                }
            }
        }
        return max;
    }

    public double maxElemant(double[][] doublemax){
        double max = doublemax[0][0];
        for (int i = 0; i < doublemax.length; i++) {
            for (int j = 0; j < doublemax[i].length; j++) {
                if(max < doublemax[i][j]){
                    max = doublemax[i][j];
                }
            }
        }
        return max;
    }

}