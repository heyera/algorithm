import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bj10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que=new LinkedList<Integer>();
        int back= -1;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String type = st.nextToken();
            switch(type){
                case "push":
                    back=Integer.parseInt(st.nextToken());
                    que.offer(back);
                    break;
                case "pop":
                    if(que.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(que.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    sb.append(que.isEmpty()? 1:0).append("\n");
                    break;
                case "front":
                    sb.append(que.isEmpty()? -1: que.peek()).append("\n");
                    break;
                case "back":
                    sb.append(que.isEmpty()? -1: back).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
