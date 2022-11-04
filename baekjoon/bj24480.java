import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj24480 {
    static int count=0;
    static int[] route=new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] graph= new LinkedList[n+1];

        for(int i=1;i<n+1;i++){
            graph[i]=new LinkedList<Integer>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int edgeInfo1=Integer.parseInt(st.nextToken());
            int edgeInfo2=Integer.parseInt(st.nextToken());
            graph[edgeInfo1].add(edgeInfo2);
            graph[edgeInfo2].add(edgeInfo1);
        }

        for(int i=1;i<n+1;i++){
            Collections.sort(graph[i],Collections.reverseOrder());
        }
        boolean[] visited= new boolean[n+1];

        dfs(graph, visited, r);
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<n+1;i++){
            sb.append(route[i]).append("\n");
        }
        System.out.println(sb);
        
    }

    public static void dfs(LinkedList<Integer>[] graph, boolean[] vist, int r){
        vist[r]=true;
        route[r]=++count;
        Iterator iter=graph[r].listIterator();
        while(iter.hasNext()){
            int w=(int) iter.next();
            if(!vist[w]){
                dfs(graph,vist,w);
            }
        }

    }
    
}
