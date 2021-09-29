import java.util.Arrays;
import java.util.Scanner;

public class bj1920 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        Arrays.sort(a);
        int m= in.nextInt();
        StringBuilder str= new StringBuilder();
        for(int i=0;i<m;i++){
            if(search(a, in.nextInt())>=0){
                str.append(1).append('\n');
            }
            else{
                str.append(0).append('\n');
            }
        }
        System.out.println(str);

        in.close();

    }
    static int search(int[] arr, int n){
        int lo=0;
        int hi=arr.length-1;

        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(n<arr[mid])
                hi=mid-1;
            else if(n>arr[mid])
                lo=mid+1;
            else
                return mid;
        }
        return -1;

    }
}
