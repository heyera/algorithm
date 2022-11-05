import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1120 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        String[] a=st.nextToken().split("");
        String[] B=st.nextToken().split("");
        int result=a.length;
        for(int i=0; i<=B.length-a.length;i++){
            int count=0;
            for(int j=0;j<a.length;j++){
                if(!a[j].equals(B[j+i]))
                    count+=1;
            }
            System.out.println(count);
            if(result>count)
                result=count;
        
            
        }
        System.out.println(result);
    }
}
