package hw5.hw5_3;

public class hw5_3 {
}

class MyRetangleMain{
    public static void main(String[] args) {

        MyRetangle retangle1 = new MyRetangle();
        retangle1.setWidth(10);
        retangle1.setDepth(20);
        System.out.println("面積為: "+retangle1.getArea());

        MyRetangle retangle2 = new MyRetangle(10,20);
        System.out.println("面積為: "+retangle2.getArea());

    }
}

class MyRetangle{
    private double width;
    private double depth;

    public MyRetangle() {
    }

    public MyRetangle(double width, double length) {
        this.width = width;
        this.depth = length;
    }


     public void setWidth(double width){
        this.width=width;
    }

    public void setDepth(double depth){
        this.depth = depth;
    }

    double getArea(){
        return  width*depth;
    }


}
