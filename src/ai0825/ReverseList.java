package ai0825;

import java.util.Arrays;
import java.util.Collections;

public class ReverseList {
    public static void main(String[] args) {
        String[] asepa = {"카리나", "윈터", "닝닝", "지젤"};
        System.out.println("원본: " + Arrays.toString(asepa));
        Collections.reverse(Arrays.asList(asepa));
        System.out.println("반전(역순):" + Arrays.toString(asepa));
    }
}