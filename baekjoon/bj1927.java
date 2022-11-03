import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1927 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que= new PriorityQueue<Integer>();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            int num= Integer.parseInt(br.readLine());
            if(num==0){
                if(que.size()==0){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(que.poll()).append("\n");
                }
            }
            else{
                que.add(num);
            }
        }
        System.out.println(sb);
    }
}
