import java.util.Scanner;

public class bj2108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] arr= new int[8001];
        int sum =0;
        int max=-4000;
        int min=4000;
        for (int i=0;i<n;i++){
            int val=in.nextInt();
            sum=sum+val;
            arr[val+4000]++;
            if(max<val)
                max=val;
            if(min>val)
                min=val;
        }
        in.close();
        int range=max-min;
        int mid=10000;
        int mode=10000;
        int count=0;
        int modeMax=0;
        boolean t=false;
        for(int i=min+4000;i<=max+4000;i++){
            if(arr[i]>0){
                if(count<(n+1)/2){
                    count += arr[i];
                    mid=i-4000;
            }
            if(modeMax < arr[i]) {
                modeMax = arr[i];
                mode = i - 4000;
                t = true;
            }
            else if(modeMax == arr[i] && t == true) {
                mode = i - 4000;
                t = false;
            }
        }
    }
    System.out.println((int)Math.round((double)sum/n));
    System.out.println(mid);
    System.out.println(mode);
    System.out.println(range);
}
}
