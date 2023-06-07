//String_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj23797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("");

        int k = 0, p = 0;

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("K")) {
                if (p > 0)
                    p -= 1;
                k += 1;
            } else {
                if (strArr[i].equals("P")) {
                    if (k > 0)
                        k -= 1;
                    p += 1;
                }
            }
        }
        System.out.println(k + p);
    }
}
