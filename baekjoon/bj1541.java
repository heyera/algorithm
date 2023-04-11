import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        StringTokenizer plusSt = new StringTokenizer(st.nextToken(), "+");
        int plusToken = plusSt.countTokens();
        for (int i = 0; i < plusToken; i++) {
            result += Integer.parseInt(plusSt.nextToken());
        }
        
        while (st.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer minusSt = new StringTokenizer(st.nextToken(), "+");
            while(minusSt.hasMoreElements()){
                temp += Integer.parseInt(minusSt.nextToken());
            }
            result -= temp;
        }
        System.out.println(result);
    }
}
