import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String str;
        while(true){
            str= br.readLine();
            if(str.equals("."))
                break;
            Stack<Character> st= new Stack<>();
            for(int i = 0; i < str.length(); i++) {
                
                char ch=str.charAt(i);
                if(ch=='('||ch=='['){
                    st.push(ch);
                }
                else if(ch==')'){
                    if(st.empty()||st.peek()!='('){
                        sb.append("no").append("\n");
                        break;
                    }
                    else{
                        st.pop();
                    }
                }
                else if(ch==']'){
                    if(st.empty()||st.peek()!='['){
                        sb.append("no").append("\n");
                        break;
                    }
                    else
                        st.pop();
                }
                if(ch=='.'){
                    if(st.empty()){
                        sb.append("yes").append("\n");
                        break;
                    }
                    else{
                        sb.append("no").append("\n");
                        break;  
                    }
                }
            }
            
        }
        System.out.println(sb);
    }
}
