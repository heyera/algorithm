//DP_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int arr[][] = new int[K +2][2];
 
        arr[0][0] = 1;  //A갯수
        arr[0][1] = 0;  //B갯수

        arr[1][1] = 0;  //A갯수
        arr[1][1] = 1;  //B갯수
        for (int i = 2; i < arr.length; i++) {
            arr[i][0]=arr[i-1][0]+arr[i-2][0];
            arr[i][1]=arr[i-1][1]+arr[i-2][1];
        }
        System.out.println(arr[K][0]+" "+arr[K][1]);
    }
}
