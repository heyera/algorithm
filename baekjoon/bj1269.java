import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int anum=Integer.parseInt(st.nextToken());
        int bnum=Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet=new HashSet<Integer>();
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<anum;i++){
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> bSet=new HashSet<Integer>();
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<bnum;i++){
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int count=0;
        for(int x:aSet){
            if(!bSet.contains(x))
                count++;
        }

        for(int x:bSet){
            if(!aSet.contains(x))
                count++;
        }
        
        System.out.println(count);
        //aSet.stream().filter(i -> bSet.stream().anyMatch(Predicate.isEqual(i)))
    }
}
