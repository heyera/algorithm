import java.io.*;

public class bj10870 {
    private static int fiv(int x){
        if(x<=1)
            return x;
        return fiv(x-1)+fiv(x-2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        System.out.println(fiv(n));
    }

}
