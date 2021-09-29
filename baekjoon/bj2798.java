import java.util.Scanner;

public class bj2798 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int m= in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++)
            arr[i]=in.nextInt();
        System.out.println(search(arr, n, m));
        in.close();
        

    }
    static int search(int[] arr, int n, int m){
        int result = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int ex=arr[i]+arr[j]+arr[k];
                    if (ex==m){
                        return ex;}
                    if(result < ex && ex<m){
                        result=ex;
                    }
                }
            }
        }
        return result;
        
    }
}
