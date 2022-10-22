import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        HashMap<Integer, Integer> n_map=new HashMap<>();
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(st.nextToken());
            if(n_map.containsKey(a)){
                n_map.put(a, n_map.get(a)+1);
            }
            else
                n_map.put(a,1);
        }
        int m=Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine()," ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            int b=Integer.parseInt(st.nextToken());
            if(n_map.containsKey(b)){
                sb.append(n_map.get(b)+" ");
            }
            else
                sb.append(0+" ");
        }
        System.out.println(sb);

    }
}
