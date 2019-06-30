package JavaMystery.Chapter15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try{
            FileOutputStream fos = new FileOutputStream("123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5); // 버퍼크기를 5로 설정

            for(int i='1'; i<= '9'; i++){ // 파일123.txt에 1부터 9까지 출력함.
                bos.write(i);
            }
            bos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
