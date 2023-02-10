import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj11399 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrLine = waitLine();

        int result = 0;
        int waitTime = 0;

        for (int i = 0; i < arrLine.size(); i++) {
            waitTime += arrLine.get(i);
            result += waitTime;
        }

        System.out.println(result);
    }

    private static ArrayList<Integer> waitLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrLine = new ArrayList<Integer>(N);

        for (int i = 0; i < N; i++) {
            arrLine.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrLine);
        return arrLine;
    }
}
