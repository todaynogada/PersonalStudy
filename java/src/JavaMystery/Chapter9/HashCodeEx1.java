package JavaMystery.Chapter9;

public class HashCodeEx1 {
    public static void main(String[] args) {
        String str1= new String("abc");
        String str2 = new String("abc");

        System.out.println(str1.equals(str2)); // String클래스는 문자열이 같으면 true
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }
}
