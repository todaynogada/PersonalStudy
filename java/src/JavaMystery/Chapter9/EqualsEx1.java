package JavaMystery.Chapter9;

public class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);
        Value v3 = new Value("test");
        Value v4 = new Value("test");

        if(v3.equals(v4)){
            System.out.println("v3과 v4는 같습니다.");
        }else{
            System.out.println("v3과 v4는 다릅니다.");
        }

        if(v1.equals(v2)){
            System.out.println("v1과 v2는 같습니다.");
        }else{
            System.out.println("v1과 v2는 다릅니다.");
        }

        v2 = v1;

        if(v1.equals(v2)){
            System.out.println("v1과 v2는 같습니다.");
        }else {
            System.out.println("v1과 v2는 다릅니다.");
        }
    }
}

class Value {
    int value;
    String name;

    Value(int value){
        this.value = value;
    }
    Value(String name){
        this.name = name;
    }
}
