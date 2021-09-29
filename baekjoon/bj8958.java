import java.util.Scanner;

public class bj8958 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arr[]=new String[in.nextInt()];
        in.close();
        for(int i=0; i<arr.length;i++){
            arr[i]=in.next();
            int sum=0;
            int plus=1;
            for(int j=0;j<arr[i].length();j++){
                if(arr[i].charAt(j)=='O'){
                    sum=sum+plus;
                    plus++;
                }
                else{
                    plus=1;
                }
            }
            System.out.println(sum);

        }
        
    }
}
