import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9655 {
    static int doll[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        doll = new int[1001];
        doll[1] = 1;
        doll[2] = 0;
        doll[3] = 1;

        int N = Integer.parseInt(br.readLine());

        for (int i = 4; i < N + 1; i++) {
            if (doll[i - 1] == 0 || doll[i - 3] == 0) {
                doll[i] = 1;
                continue;
            }
            doll[i] = 0;

        }

        if (doll[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }

}
