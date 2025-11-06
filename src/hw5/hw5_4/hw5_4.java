package hw5.hw5_4;

import java.util.Random;

public class hw5_4 {
    public static void main(String[] args) {
        VerificationCode v = new VerificationCode();
        System.out.println("驗證碼為:"+v.genAuthCode());
    }
}

class VerificationCode{
    Random random = new Random();
    String verificationCode;
    StringBuilder s = new StringBuilder();

    public VerificationCode(){
        for (int i = 1; i <=9 ; i++) {
            s.append(i);
        }
        for (char i = 'a'; i <='z' ; i++) {
            s.append(i);
        }
        for (char i = 'A'; i <='Z' ; i++) {
            s.append(i);
        }
    }

    public String genAuthCode(){
        String code = "";
        for (int i = 0; i < 8 ; i++) {
            int codeindex = random.nextInt(s.length());
            code = code + s.charAt(codeindex);
        }
        this.verificationCode = code;
        return verificationCode;
    }

}


