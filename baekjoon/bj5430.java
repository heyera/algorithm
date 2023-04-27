//Parsing_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < tc; j++) {

            String ACL = br.readLine();
            int numSize = Integer.parseInt(br.readLine());
            int numArr[] = inNumStr(br.readLine(), numSize);

            int head = 0;
            int tail = numSize;

            boolean now = true; // true면 헤드전지 false면 테일전진

            if (ACL.length() == 0) {
                sb.append("error").append("\n");
                continue;
            }

            boolean bk = false;
            for (int i = 0; i < ACL.length(); i++) {
                String rd = ACL.substring(i, i + 1);
                if (rd.equals("R")) {
                    now = now ? false : true;
                    continue;
                }
                if (rd.equals("D")) {
                    if (now) {
                        head += 1;
                    } else {
                        tail -= 1;
                    }
                }
                if (head > tail) {
                    sb.append("error").append("\n");
                    bk = true;
                    break;
                }
            }
            if (bk)
                continue;

            sb.append("[");
            // head=tail 경우 비어있음
            if (head == tail) {
                sb.append("]\n");
                continue;
            }
            // tail이 size를 그대로 받와왔기에 처음에 못해준 -1을 마지막에 해줌
            tail -= 1;

            if (now) {
                for (int k = head; k < tail; k++)
                    sb.append(numArr[k]).append(",");
                sb.append(numArr[tail]).append("]\n");
            } else {
                for (int k = tail; k > head; k--)
                    sb.append(numArr[k]).append(",");
                sb.append(numArr[head]).append("]\n");
            }

        }
        System.out.println(sb);
    }

    private static int[] inNumStr(String str, int size) {
        String num = str.substring(1, str.length() - 1);
        StringTokenizer st = new StringTokenizer(num, ",");
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

}
