import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1966 {

    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> printQue;
    static Queue<Integer> indexQue;
    static int N; // 문서갯수
    static int M; // 중요도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            printQue = new LinkedList<Integer>();
            indexQue = new LinkedList<Integer>();

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                printQue.add(num);
                indexQue.add(j);
            }

            printerQue();
        }
        System.out.println(sb);

    }

    private static void printerQue() {

        int count = 1;

        while (!printQue.isEmpty()) {

            int maxValue = Collections.max(printQue);
            int headValue = printQue.peek();
            int headIndex = indexQue.peek();

            if (headValue == maxValue) {
                if (headIndex == M) {
                    sb.append(count).append("\n");
                    break;
                }

                count += 1;
                printQue.remove();
                indexQue.remove();
            } else {
                printQue.add(printQue.poll());
                indexQue.add(indexQue.poll());
            }

        }

    }
}
