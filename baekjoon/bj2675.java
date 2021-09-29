import java.util.Scanner;

public class bj2675 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            String str= new String();
            StringBuilder strb= new StringBuilder();
            int num=in.nextInt();
            str=in.next();
            for(int j=0;j<str.length();j++){
                for(int s=0;s<num;s++){
                    strb.append((str.charAt(j)));
                }                
            }
            System.out.println(strb.toString());
        }
    }
}
