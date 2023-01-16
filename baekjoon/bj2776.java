import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Set<Integer> note1 = new HashSet<Integer>(N);

            for (int j = 0; j < N; j++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                sb.append(note1.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append("\n");
            }
            System.out.println(sb);
        }

    }
    /*
     * static void input() throws IOException {
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * int N = Integer.parseInt(br.readLine());
     * StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
     * 
     * note1 = new HashSet<Integer>(N);
     * for (int i = 0; i < N; i++) {
     * note1.add(Integer.parseInt(st1.nextToken()));
     * }
     * 
     * StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
     * int M = Integer.parseInt(br.readLine());
     * 
     * note2 = new HashSet<Integer>(M);
     * for (int i = 0; i < N; i++) {
     * note2.add(Integer.parseInt(st2.nextToken()));
     * }
     * 
     * }
     * 
     * static void answerContains() throws IOException {
     * Set<Integer> note1;
     * 
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * 
     * int N = Integer.parseInt(br.readLine());
     * StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
     * 
     * note1 = new HashSet<Integer>(N);
     * for (int i = 0; i < N; i++) {
     * note1.add(Integer.parseInt(st1.nextToken()));
     * }
     * 
     * int M = Integer.parseInt(br.readLine());
     * StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
     * 
     * StringBuilder sb = new StringBuilder();
     * for (int i = 0; i < M; i++) {
     * int num = Integer.parseInt(st2.nextToken());
     * if (note1.contains(num)) {
     * sb.append("1").append("\n");
     * continue;
     * }
     * sb.append("0").append("\n");
     * }
     * System.out.println(sb);
     * }
     */
}
