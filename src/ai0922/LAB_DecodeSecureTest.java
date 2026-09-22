package ai0922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LAB_DecodeSecureTest {
    public static void main(String[] args) {
        try {
            String line = "";
            String decode = "";
            BufferedReader br = new BufferedReader(new FileReader("secure.txt"));
            FileWriter fw = new FileWriter("decodeSecure.txt");

            while (true){
                line = br.readLine();
                if (line == null)
                    break;

                decode = "";
                for (int i = 0; i < line.length(); i++){
                    int num = (int)line.charAt(i);
                    num -= 100; // 해독을 위해 -100 으로 변경
                    decode += (char)num;
                }

                fw.write(decode + "\n");
            }

            fw.close();
            br.close();
            System.out.println("--- decodeSecure.txt 해독 완료 ---");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}