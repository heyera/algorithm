//String_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj13022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inStr = br.readLine();

        // 만들 수 있는 울프 경우의수 만들기
        String[] wolfArr = { "w", "o", "l", "f" };
        HashSet<String> wolfSet = new HashSet<>();
        for (int i = 1; i < 13; i++) {
            String str = "";
            for (int j = 0; j < 4; j++) {
                for (int a = 0; a < i; a++) {
                    str = str + wolfArr[j];
                }
            }

            wolfSet.add(str);
        }

        int index = 0;
        while (index < inStr.length()) {
            boolean state = false;

            for (String i : wolfSet) {

                if (inStr.substring(index).startsWith(i)) {
                    index += i.length();
                    state = true;
                }
            }

            if (!state)
                break;
        }

        int result = (index == inStr.length()) ? 1 : 0;
        System.out.println(result);

    }
}
