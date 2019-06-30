package JavaMystery.Chapter15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWRiterEx {
    public static void main(String[] args) {
        String inputData = "ABCD";
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        int data = 0;

        try{
            while((data = input.read()) != -1){
                output.write(data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("input data : " + inputData);
        System.out.println("output data : " + output.toString());
        System.out.println("output data : " + output.getBuffer().toString());
    }
}
