package JavaMystery.Chapter15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx4 {
    public static void main(String[] args) {
        String currDir = System.getProperty("user.dir"); // 현재디렉토리 가져옴
        File dir = new File(currDir); // 파일생성

        File[] files= dir.listFiles(); // 디렉토리 리스트 배열로 반환

        for(int i=0; i<files.length; i++){
            File f =  files[i];
            String name = f.getName();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mma");
            String attribute = "";
            String size = "";
            if(files[i].isDirectory()){ // 디렉토리 체크
                attribute = "DIR";
            }else {
                size = f.length() + "";
                attribute = f.canRead() ? "R" : " ";
                attribute += f.canWrite() ? "W" : " ";
                attribute += f.isHidden() ? "H" : " ";
            }

            System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);

        }
    }
}
