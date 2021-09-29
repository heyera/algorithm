import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n= Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            StringBuilder str= new StringBuilder();
            int open=0;
            str.append(br.readLine());
            if(str.length()%2==1){
                result.append("NO\n");
                continue;
            }
            for(int j=0;j<str.length();j++){
                if(open<0){
                    break;
                }
                if(str.charAt(j)=='('){
                    open++;
                }
                else{
                    open--;
                }
            }
            if(open==0){
                result.append("YES\n");
            }
            else{
                result.append("NO\n");
            }

        }
        System.out.println(result);

        
    }
    
}
