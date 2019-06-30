package JavaMystery.Chapter15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileViewer {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int data = 0;
        while(true) {
            try {
                if (!((data = fis.read()) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            char c = (char)data;
            System.out.println(c);
        }
    }
}
