package JavaMystery.Other;

public class toStringEx {
    public static void main(String[] args) {
        Pen p = new Pen("모나미" , "검정" , 1);
        System.out.println(p);
    }

}

class Pen{
    String name = ""; // 제품 이랑
    String color = ""; // 색
    int boldWidth; // 굵기

    public Pen() {
    }

    public Pen(String name, String color, int boldWidth) {
        super();
        this.name = name;
        this.color = color;
        this.boldWidth = boldWidth;
    }


    public String toString() {
        // TODO Auto-generated method stub
        return "[제품 : " + name + ", 색상 : " + color + " , 두께 : " + boldWidth + " ] " ;
    }

}

