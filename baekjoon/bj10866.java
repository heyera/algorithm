import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class bj10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deqe = new ArrayDeque<Integer>();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            String str=st.nextToken();
            //int num=Integer.parseInt(st.nextToken());
            switch (str) {
                case "push_front":{
                    deqe.addFirst(Integer.parseInt(st.nextToken()));                    
                    break;
                }
                case "push_back":{
                    deqe.addLast(Integer.parseInt(st.nextToken()));                    
                    break;
                }
                case "pop_front":{
                    if(deqe.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deqe.getFirst()+"\n");
                        deqe.pollFirst();
                    }                    
                    break;
                }
                case "pop_back":{
                    if(deqe.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deqe.getLast()+"\n");
                        deqe.pollLast();
                    }            
                    break;
                }
                case "size":{
                    if(deqe.isEmpty()){
                        sb.append("0\n");
                    }
                    else{
                        sb.append(deqe.size()+"\n");
                    }                    
                    break;
                }
                case "empty":{
                    if(deqe.isEmpty()){
                        sb.append("1\n");
                    }
                    else{
                        sb.append("0"+"\n");
                    }    
                    break;
                }
                case "front":{
                    if(deqe.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deqe.getFirst()+"\n");
                    }                    
                    break;
                }
                case "back":{
                    if(deqe.isEmpty()){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(deqe.getLast()+"\n");
                    }                    
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println(sb);


    }
}
