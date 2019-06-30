package JavaMystery.Chapter9;

class Person {
    long id;

    Person(long id){
        this.id = id;
    }
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Person){
            return id == ((Person)obj).id;
        }else{
            return false;
        }
    }
}

public class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(80000L);
        Person p2 = new Person(80000L);

        if(p1==p2){
            System.out.println("p1과 p2는 같습니다.");
        }else{
            System.out.println("p1과 p2는 다릅니다.");
        }

        if(p1.equals(p2)){
            System.out.println("p1과 p2는 같습니다.");
        }else{
            System.out.println("p1과 p2는 다릅니다.");
        }
    }
}
