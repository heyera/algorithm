import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        HashSet<String> peopleset=new HashSet<String>();

        for(int i=0;i<n;i++){
            peopleset.add(br.readLine());
        }
        StringBuilder sb=new StringBuilder();
        ArrayList<String> result= new ArrayList<String>();
        for(int i=0;i<m;i++){
            String a=br.readLine();
            if(peopleset.contains(a)){
                result.add(a);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        // for(int i=0;i<result.size();i++){
        //     System.out.println(result.get(i));
        // }
        result.stream()
            .forEach(i->System.out.println(i));
    }
}
