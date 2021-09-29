import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(br.readLine());

            
            

        }
        

        
    }
    static class point implements Comparable<point>{
        int x,y;
        public point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(point p){
            if(this.x>p.x){
                return x;
            }
            else if(this.x==p.x){
                if(this.y>p.y){
                    return 1;
                }
            }
            return -1;

        }
    }
}
