import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        int sugar[]=new int[5001];
        sugar[0]=Integer.MAX_VALUE;
        sugar[1]=Integer.MAX_VALUE;
        sugar[2]=Integer.MAX_VALUE;
        sugar[3]=1;
        sugar[4]=Integer.MAX_VALUE;
        sugar[5]=1;

        for (int i = 6; i < N+1; i++) {
            sugar[i]=Math.min(sugar[i-3],sugar[i-5])+1;
            if(sugar[i]<0){
                sugar[i]=Integer.MAX_VALUE;
            }
        }
        //System.out.print("test  == " );
        //System.out.println(sugar[N]);

        if(sugar[N]>=Integer.MAX_VALUE||sugar[N]<0){
            System.out.println("-1");
        }else{
            System.out.println(sugar[N]);
        }

    }
}
