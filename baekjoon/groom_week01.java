import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.StringTokenizer;
class groom_week01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		Queue<Integer> paylist= new LinkedList<Integer>();
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine()," ");
			String str=st.nextToken();
			int money=Integer.parseInt(st.nextToken());
			switch(str){
				case "deposit":{
					n+=money;
					break;
				}
				case "pay":{
					if(money<n){
						n-=money;
					}
					break;
				}
				case "reservation":{
					paylist.add(money);
					break;
				}
			}
			while(paylist.size()!=0){
				if(n>=paylist.peek()){
					n-=paylist.peek();
					paylist.poll();
					//System.out.print("while문 if문");
				}
				else
					break;
			}
			//System.out.print("n값 "+n+"\n");
		}
		
		System.out.println(n);
	}
}