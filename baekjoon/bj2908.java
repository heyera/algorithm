import java.util.Scanner;
public class bj2908 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1=in.nextInt();
        int n2 =in.nextInt();
        in.close();
        n1=Integer.parseInt(new StringBuilder().append(n1).reverse().toString());
        n2=Integer.parseInt(new StringBuilder().append(n2).reverse().toString());
        System.out.println(n1>n2?n1:n2);
        

    }
}
