package JavaMystery.Chapter15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static java.awt.Color.white;

public class IOEx3 {
    public static void main(String[] args) {

        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;

        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Source :" + Arrays.toString(inSrc));

        try{
            while(input.available() > 0){
                int len = input.read(temp); // 데이터를 보냄
                output.write(temp, 0 , len); // 길이만큼 읽음
              //  output.write(temp); // 데이터를 전체 읽음
                System.out.println("temp :" + Arrays.toString(temp));

                outSrc = output.toByteArray(); // 바이트배열로 반환함
                printArrays(temp, outSrc);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp :" + Arrays.toString(temp));
        System.out.println("Output Source :" + Arrays.toString(outSrc));
    }
}
