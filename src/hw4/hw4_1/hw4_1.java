package hw4.hw4_1;

public class hw4_1 {
  public static void main(String[] args) {
      //問題一、
      System.out.println("題目一:");
      int[] l ={29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
      CalList calList = new CalList(l);
      calList.biggerThanAvg();
      System.out.println();
      System.out.println("-----------------------");

      //問題二、
      System.out.println("題目二:");
      ReverseString reverseString = new ReverseString("Hello World");
      System.out.println("-----------------------");

      //問題三、
      System.out.println("題目三:");
      String[] planet = {"mercury","venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
      CalLetter calLetter = new CalLetter(planet);
      calLetter.count();
      System.out.println("-----------------------");
  }

}




/*有個一維陣列如下: {29, 100, 39, 41, 50, 8, 66, 77, 95, 15}，請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素，(提示:陣列,length屬性)*/
class CalList{
    private int[] l  ;
    private int avg;

    private int count;

  //建構子
  public CalList(int[] l) {
      this.l = l;
      int sum=0;
      for (int i = 0; i < l.length; i++) {
          sum = sum + l[i];
      }
      this.avg = (sum/(l.length));
      System.out.println("此陣列平均值為:"+avg);

      for (int i = 0; i <l.length ; i++) {
          if (l[i]>this.avg) {
              count++;
          }
      }
  }
  //計算平均(直接放入建構子好了，不用另外呼叫方法)
  /*public int avg(int[] l){
      int sum=0;
      for (int i = 0; i < l.length; i++) {
          sum = sum + l[i];
      }
      this.avg = (sum/(l.length));
      return avg;
    } */

  //計算比平均值大的元素
  public void biggerThanAvg(){
      int check=0;
      System.out.print("比平均值大的元素有:");
      for (int i = 0; i <l.length ; i++) {
          if(l[i]>this.avg){
              check++;
              System.out.print(count==check?l[i] :l[i]+",");
          }
      }
  }
}

/* 請建立一個字串,經過程式執行後,輸入結果是反過來的，例如String s = “Hello World”,執行結果即為dlroW olleH(提示:String方法,陣列)*/
class ReverseString{
    private StringBuilder s = new StringBuilder();
    public ReverseString(String s) {
        this.s.append(s);
        this.s.reverse();
        System.out.println(this.s.toString());
    }
}

/*有個字串陣列如下 (八大行星): {“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)(提示:字元比對,String方法)*/
class CalLetter{
  private String[] s ;
  private int count;

  public CalLetter(String[] s) {
      this.s = s;
  }

  public void count(){
      for (String ss : s) {
          for (int i = 0; i <ss.length() ; i++) {
              char c = ss.charAt(i);
              switch (c){
                  case'a':
                  case'e':
                  case'i':
                  case'o':
                  case'u':
                      count++;
                      break;
                  default:
                      break;
              }
          }
      }
      System.out.println("總共有"+count+"個字母");
  }
}