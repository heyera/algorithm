import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj24479 {
    static int count=0;
    static int[] route=new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int r= Integer.parseInt(st.nextToken());
        
        LinkedList<Integer>[] graph=new LinkedList[n+1];

        for(int i=0;i<graph.length;i++){
            graph[i]=new LinkedList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i=0;i<n+1;i++){
            Collections.sort(graph[i]);
        }

        boolean[] visited = new boolean[n+1];

        dfs(visited, graph, r);

        StringBuilder sb= new StringBuilder();
        for(int i=1;i<n+1;i++){
            sb.append(route[i]).append("\n");
        }

        System.out.println(sb);

    

    }
    public static void dfs(boolean[] visited, LinkedList<Integer>[] E, int R) {          //V : 정점 집합, E : 간선 집합, R : 시작 정점

        visited[R]=true;                                              // 시작 정점 R을 방문 했다고 표시한다.
        route[R]=++count;
        Iterator iter= E[R].listIterator();
        while(iter.hasNext()){
            int w=(int) iter.next();
            if(!visited[w]){
                dfs(visited, E, w);
            }
        }

        // for each x ∈ E(R)                                              // E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
        //     if (visited[x] = NO) then dfs(V, E, x);
    }
}
