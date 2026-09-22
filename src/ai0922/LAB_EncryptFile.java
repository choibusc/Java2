package ai0922;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LAB_EncryptFile {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            FileWriter fw = new FileWriter("secure.txt");
            String inStr = "";

            while (true) {
                System.out.print("스파이에게 전달할 메시지 ==> ");
                inStr = s.nextLine();

                if (inStr.equals("")) {
                    break;
                }

                String secure = "";
                for (int i = 0; i < inStr.length(); i++) {
                    int num = (int) inStr.charAt(i);
                    num += 100;
                    secure += (char) num;
                }

                fw.write(secure + "\n");
            }

            fw.close();
            System.out.println("--- secure.txt 암호화 완료 ---");
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
