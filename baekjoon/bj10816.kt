import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br= BufferedReader(InputStreamReader(System.`in`))
    var n=br.readLine().toInt()
    val nst= StringTokenizer(br.readLine()," ")
    val nMap=mutableMapOf<Int,Int>()
    for(i in 0 until n) {
        var a: Int = nst.nextToken().toInt()
        if(nMap.containsKey(a))
            nMap.put(a,nMap.getValue(a)+1)
        else
            nMap.put(a,1)
    }
    var m=br.readLine().toInt()
    val mst= StringTokenizer(br.readLine()," ")
    val sb= StringBuilder()
    for(i in 0 until m){
        var mnum=mst.nextToken().toInt()
        if(nMap.containsKey(mnum)){
            sb.append(nMap.getValue(mnum)," ")
        }
        else
            sb.append(0," ")
    }
    print(sb)

}