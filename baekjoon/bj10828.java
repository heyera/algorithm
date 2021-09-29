import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10828 {
    public static int[] stack;
    public static int size=0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        stack=new int[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()){
                case "push":
                    stack[size]=Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case "pop":
                    if(size == 0) {
                        sb.append(-1).append('\n');
                        }
                    else {
                        sb.append(stack[size - 1]).append('\n');
                        stack[size - 1] = 0;
                        size--;
                    }
                    break;
                case "size":
                    sb.append(size).append('\n');
                    break;
                case "empty":
                    if(size==0){
                        sb.append(1).append('\n');
                    }
                    else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "top":
                    if(size==0){
                        sb.append(-1).append('\n');
                    }
                    else{
                        sb.append(stack[size-1]).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
