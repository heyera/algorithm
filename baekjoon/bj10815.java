import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashSet<Integer> numcard=new HashSet<Integer>();

        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            numcard.add(Integer.parseInt(st.nextToken()));
        }
        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine(), " ");
        StringBuilder sb= new StringBuilder();
        // numcard.stream()
        //     .filter(i -> i.equals(st.nextToken())?sb.append(1+" "):sb.append(0+" "));
        for(int i=0;i<m;i++){
            if(numcard.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1+" ");
            }
            else
                sb.append(0+" ");
        }
        System.out.println(sb);


    }
}
