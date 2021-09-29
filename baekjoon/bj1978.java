import java.util.Scanner;

public class bj1978 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int pass = 0;
            if (x == 1) {
                continue;
            }
            for (int j = 2; j <= Math.sqrt(x); j++) {
                if (x % j == 0) {
                    pass++;
                }
            }
            if (pass == 0) {
                count++;
            }

        }
        System.out.println(count);
        in.close();
    }
}
