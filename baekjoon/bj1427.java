import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<Integer>(1000000);

        while (N > 0) {
            arr.add(N % 10);
            N /= 10;
        }

        Collections.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        System.out.println(sb);
    }
}
