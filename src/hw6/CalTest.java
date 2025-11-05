package hw6;

import java.util.Scanner;

public class CalTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入x值:");
        String input1 = sc.nextLine();
        System.out.println("請輸入y值:");
        String input2 = sc.nextLine();
        try {
            Calculator calculator = new Calculator(input1,input2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
