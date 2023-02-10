import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();

        int min = 1;
        boolean NO = true;
        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if (min <= inputNum) {
                for (int j = min; j <= inputNum; j++) {
                    st.push(j);
                    plus(sb);
                }
                min = st.peek() + 1;
                st.pop();
                minus(sb);
                //System.out.println(st);
                continue;
            }

            if (min > inputNum) {
                if (!st.contains(inputNum)) {
                    NO = false;
                    break;
                }
                while(true){
                    if(st.pop()==inputNum){
                        minus(sb);
                        break;
                    }
                    minus(sb);
                }
                //System.out.println(st);
                continue;
            }
        }
        if (NO) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }

    static void plus(StringBuilder sb) {
        sb.append("+").append("\n");
    }

    static void minus(StringBuilder sb) {
        sb.append("-").append("\n");
    }

}
