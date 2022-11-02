import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj25501 {
    static int recursionCount=0;
    public static int recursion(String s, int l,int r){
        recursionCount++;
        if(l>=r)return 1;
        else if(s.charAt(l)!=s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        recursionCount=0;
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<T;i++){
            String inputStr=br.readLine();
            sb.append(isPalindrome(inputStr)+" "+recursionCount+"\n");
        }
        System.out.println(sb);

    }
}
