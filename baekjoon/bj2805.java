//Binary_search_Java

import java.io.*;
import java.util.*;

public class bj2805 {
    public static void main(String[] args) throws IOException, InterruptedException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> trees=new ArrayList<Integer>();
        int max=0;
        int min=0;
        int mid=0;
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(st.nextToken());
            trees.add(a);
            if(max<a)
                max=a;
        }
        double num;
        while(max>min){
            mid=(max+min)/2;
            num=0;
            for(int i=0;i<trees.size();i++){
                if(trees.get(i)-mid>0)
                    num+=trees.get(i)-mid;
            }
            if(num<m)
                max=mid;
            else
                min=mid+1;
        }
        System.out.println(min-1);

        
    }
}
