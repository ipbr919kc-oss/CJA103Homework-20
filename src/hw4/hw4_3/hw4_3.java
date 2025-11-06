package hw4.hw4_3;

/*
請設計由鍵盤輸入三個整數，分別代表西元yyyy年，mm月，dd日，執行後會顯示是該年的第幾天
例：輸入1984 9 8 三個號碼後，程式會顯示「輸入的日期為該年第252天」
*/

import java.util.Scanner;

public class hw4_3 {
    public static void main(String[] args) {
        inputDateTime i = new inputDateTime();
        i.cal_TotalDays();
    }

}

class inputDateTime{

    private int[] leapYear = {31,29,31,30,31,30,31,31,30,31,30,31};
    private int[] commonYear = {31,28,31,30,31,30,31,31,30,31,30,31};
    private int year;
    private int month;
    private int date;
    Scanner sc = new Scanner(System.in);

  public inputDateTime(){

      while(true) {
          System.out.println("請輸入西元yyyy年:");
          System.out.println("(請輸入整數)");
          System.out.println("-----------");
          if (sc.hasNextInt()){
              this.year = sc.nextInt();
              if(year>=0){
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

      while(true) {
          System.out.println("請輸入mm月份:");
          System.out.println("(請輸入整數)");
          System.out.println("-----------");
          if (sc.hasNextInt()){
              this.month = sc.nextInt();
              if(month>0 && month<13){
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

      while(true) {
          System.out.println("請輸入dd日期:");
          System.out.println("(請輸入整數)");
          System.out.println("-----------");
          if (sc.hasNextInt()){
              this.date = sc.nextInt();
              if (checkLeapYear()) {
                  if(month == 1 || month == 3 ||month == 5 || month == 7 || month == 8 || month == 10|| month == 12){
                      if(date>0 && date<32){
                          break;
                      }else{
                          System.out.println("輸入錯誤，請重新輸入");
                          System.out.println("------------------");
                      }
                  }else if(month ==2){
                      if(date>0 && date<30){
                          break;
                      }else{
                          System.out.println("輸入錯誤，請重新輸入");
                          System.out.println("------------------");
                      }
                  }else{
                      if(date>0 && date<31){
                          break;
                      }else{
                          System.out.println("輸入錯誤，請重新輸入");
                          System.out.println("------------------");
                      }
                  }
              }else{
                  if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10|| month == 12){
                      if(date>0 && date<32){
                          break;
                      }else{
                          System.out.println("輸入錯誤，請重新輸入");
                          System.out.println("------------------");
                      }
                  }else if(month ==2){
                      if(date>0 && date<29){
                          break;
                      }else{
                          System.out.println("輸入錯誤，請重新輸入");
                          System.out.println("------------------");
                      }
                  }else{
                      if(date>0 && date<31){
                          break;
                      }else{
                          System.out.println("輸入錯誤，請重新輸入");
                          System.out.println("------------------");
                      }
                  }
              }
          }else {
              System.out.println("請輸入整數~~");
              sc.next();
          }
      }
  }

  private boolean checkLeapYear(){
      if(year%100==0){
          if(year%400==0){
              //System.out.println("是閏年");
              return true;
          }else{
              //System.out.println("是平年");
              return false;
          }
      }else{
          if(year%4==0){
              //System.out.println("是閏年");
              return true;
          }else{
              //System.out.println("是平年");
              return false;
          }
      }
  }

  public void cal_TotalDays(){
      int sum = 0 ;
      if(checkLeapYear()){
          for (int i = 0; i <month-1 ; i++) {
              sum = sum + leapYear[i];
          }
          sum += date;
          System.out.println("輸入的日期為該年第"+sum+"天");
      }else{
          for (int i = 0; i <month-1 ; i++) {
              sum = sum + commonYear[i];
          }
          sum += date;
          System.out.println("輸入的日期為該年第"+sum+"天");
      }
  }
}



//日後優化程式碼可以學習的方向:
/* =============================  以下為AI寫法...真的甘拜下風Orz   ==================================== */
/*

package com.KC.practice4;

import java.util.Scanner;

public class practice4 {
  public static void main(String[] args) {
      inputDateTime i = new inputDateTime();
      i.cal_TotalDays();
  }
}

class inputDateTime {

  private int year;
  private int month;
  private int date;
  Scanner sc = new Scanner(System.in);

  // 闰年和平年的每个月天数
  private int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  // 构造函数，输入年份、月份、日期
  public inputDateTime() {
      while (true) {
          System.out.println("請輸入西元yyyy年:");
          if (sc.hasNextInt()) {
              this.year = sc.nextInt();
              if (year >= 0) {
                  break;
              } else {
                  System.out.println("輸入錯誤，請重新輸入");
              }
          } else {
              System.out.println("請輸入整數~~");
              sc.next(); // 清除输入的错误数据
          }
      }

      while (true) {
          System.out.println("請輸入mm月份:");
          if (sc.hasNextInt()) {
              this.month = sc.nextInt();
              if (month > 0 && month < 13) {
                  break;
              } else {
                  System.out.println("輸入錯誤，請重新輸入");
              }
          } else {
              System.out.println("請輸入整數~~");
              sc.next();
          }
      }

      while (true) {
          System.out.println("請輸入dd日期:");
          if (sc.hasNextInt()) {
              this.date = sc.nextInt();
              if (isValidDate()) {
                  break;
              } else {
                  System.out.println("輸入錯誤，請重新輸入");
              }
          } else {
              System.out.println("請輸入整數~~");
              sc.next();
          }
      }
  }

  // 判断日期是否有效
  private boolean isValidDate() {
      int[] daysInMonth = isLeapYear() ? leapYear : commonYear; // 根据闰年或平年选择正确的月份天数数组

      // 判断日期范围，依据月份和年份选择正确的天数
      return date >= 1 && date <= daysInMonth[month - 1];
  }

  // 判断是否为闰年
  private boolean isLeapYear() {
      if (year % 400 == 0) {
          return true;
      } else if (year % 100 == 0) {
          return false;
      } else if (year % 4 == 0) {
          return true;
      }
      return false;
  }

  // 计算该日期是当年的第几天
  public void cal_TotalDays() {
      int[] daysInMonth = isLeapYear() ? leapYear : commonYear; // 根据闰年或平年选择正确的月份天数数组
      int sum = 0;

      // 计算1到当前月份的天数总和
      for (int i = 0; i < month - 1; i++) {
          sum += daysInMonth[i];
      }

      // 加上当前月份的日期
      sum += date;

      System.out.println("輸入的日期為該年第" + sum + "天");
  }
}
*/
/* ====================================================================================================== */