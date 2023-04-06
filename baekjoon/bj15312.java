import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj15312 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> alpa = new HashMap<String, Integer>();
        alpa.put("A", 3);
        alpa.put("B", 2);
        alpa.put("C", 1);
        alpa.put("D", 2);
        alpa.put("E", 3);
        alpa.put("F", 3);
        alpa.put("G", 2);
        alpa.put("H", 3);
        alpa.put("I", 3);
        alpa.put("J", 2);
        alpa.put("K", 2);
        alpa.put("L", 1);
        alpa.put("M", 2);
        alpa.put("N", 2);
        alpa.put("O", 1);
        alpa.put("P", 2);
        alpa.put("Q", 2);
        alpa.put("R", 2);
        alpa.put("S", 1);
        alpa.put("T", 2);
        alpa.put("U", 1);
        alpa.put("V", 1);
        alpa.put("W", 1);
        alpa.put("X", 2);
        alpa.put("Y", 2);
        alpa.put("Z", 1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int str[] = new int[A.length() + B.length() - 1];
        int temp[];
        int count = 0;

        for (int i = 0; i < A.length(); i++) {
            str[count] = (alpa.get(A.substring(i, i + 1)) + alpa.get(B.substring(i, i + 1))) % 10;
            count += 1;
            if (i == A.length() - 1)
                break;
            str[count] = (alpa.get(B.substring(i, i + 1)) + alpa.get(A.substring(i + 1, i + 2))) % 10;
            count += 1;
        }
        while (str.length != 2) {
            temp = new int[str.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (str[i] + str[i + 1]) % 10;
            }
            str = temp;
        }
        System.out.print(str[0]);
        System.out.print(str[1]);
    }
}
