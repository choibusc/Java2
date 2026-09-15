package ai0915;

import java.util.Scanner;

public class PasswordGenerator {

    public static boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isAlphabetic(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("새로운 비밀번호를 입력하세요 :");
        String password = s.nextLine();

        if (checkPassword(password)) {
            System.out.println("Good~ 비밀번호가 올바르게 생성되었어요.");
        } else {
            System.out.println("오류! 비밀번호가 규칙에 맞지 않습니다.");
        }

        s.close();
    }
}