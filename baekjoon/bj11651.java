import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        Stack<Integer> st= new Stack<>();
        int sum=0;
        for(int i=0;i<k;i++){
            int n=Integer.parseInt(br.readLine());
            if(n!=0){
                sum+=st.push(n);
            }
            else{
                sum-=(st.pop());
            }
        }
        System.out.println(sum);
    }
}
