
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.min
import java.util.*


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s=br.readLine()
    val st0= StringTokenizer(s,"0")
    val st1= StringTokenizer(s,"1")
    print(min(st0.countTokens(),st1.countTokens()))
}
