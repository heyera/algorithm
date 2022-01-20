import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
       Queue<Integer> deck= new LinkedList<>();
       for(int i=0;i<n;i++){
            deck.add(i+1);
       }
           while(deck.size()>1){
               deck.poll();
               deck.add(deck.poll());
           }
           System.out.println(deck.poll());
    }
}

