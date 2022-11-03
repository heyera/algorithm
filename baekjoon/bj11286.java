import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class bj11286 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que= new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(Math.abs(o1)==Math.abs(o2)){
                    return Integer.compare(o1, o2);
                }
                return Integer.compare(Math.abs(o1), Math.abs(o2));         
            }
        });
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
                que.offer(num);
            }
        }
        System.out.println(sb);
        
    }
}
