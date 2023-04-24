//String_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine()); // str의 길이 s
        String str = br.readLine();
        char ch[] = str.toCharArray();

        // StringBuilder sb=new StringBuilder("I");
        // for (int i = 0; i < n; i++) {
        // sb.append("OI");
        // }
        // String ioi=sb.toString();
        // int oio=ioi.length();

        // int count=0;
        // for (int i = 0; i < s-oio+1; i++) {
        // if(str.substring(i,oio+i).equals(ioi)){
        // count+=1;
        // }
        // }
        // System.out.println(count);

        int count = 0;
        int patternCount = 0;
        for (int i = 1; i < s - 1; i++) {
            if (ch[i - 1] == 'I' && ch[i] == 'O' && ch[i + 1] == 'I') {
                patternCount += 1;
                if (patternCount == n) {
                    patternCount -= 1;
                    count += 1;
                }
                i++;
                continue;
            }
            patternCount = 0;
        }
        System.out.println(count);
    }
}
