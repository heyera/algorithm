import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;

public class bj1654 {

    static int K;
    static int N;
    static List<Integer> lanLength;

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(getMaxSize());
    }

    private static int getMaxSize() {
        int max = lanLength.get(K - 1);
        int min = 1;
        int mid = 0;
        int size = 0;

        while (min <= max) {
            mid = (max + min) / 2;

            if (getCount(mid) < N) {
                max = mid - 1;
                continue;
            }

            min = mid + 1;
            size = Math.max(size, mid);
        }
        return size;
    }

    private static long getCount(int mid) {
        long count = 0;
        for (int num : lanLength) {
            count += num / mid;
        }
        return count;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lanLength = new ArrayList<>(K);

        for (int i = 0; i < K; i++) {
            lanLength.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(lanLength);
    }

}
