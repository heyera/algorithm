import java.util.Scanner;

public class bj2577 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[2];
        int total=1;
        for(int i=0;i<3;i++){
            num[i]=in.nextInt();
        }
        for(int i=0;i<3;i++){
           total=total*num[i];
        }
        int[] lst= new int[9];
        System.out.println(total    );
        in.close();

    }
}
