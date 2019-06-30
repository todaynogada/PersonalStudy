package JavaMystery.Chapter15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {
    public static void main(String[] args) {
        byte[] arr1 = {0,1,2};
        byte[] arr2 = {3,4,5};
        byte[] arr3 = {6,7,8};
        byte[] outSrc = null;

        Vector v = new Vector();
        // 바이트배열을 Vector에 담는다
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));

        // 여러개의 배열의 데이터 값을  SequenceInputStream로 하나로 만든다
        SequenceInputStream input = new SequenceInputStream(v.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        try{
            while((data = input.read()) != -1){
                output.write(data);
            }
        }catch (IOException e){

        }
        outSrc = output.toByteArray();

        System.out.println("Input Source :" + Arrays.toString(arr1));
        System.out.println("Input Source :" + Arrays.toString(arr2));
        System.out.println("Input Source :" + Arrays.toString(arr3));
        System.out.println("Input Source :" + Arrays.toString(outSrc));


    }
}
