import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    while (true){
        val str:String = br.readLine()
        if(str==".")
            break
        val st= Stack<Char>()
        for(i in str){
            if(i=='('||i=='['){
                st.push(i)
            }
            else if(i==')'){
                if(st.empty()||st.peek()!='('){
                    sb.append("no\n")
                    break
                }
                else
                    st.pop()
            }
            else if(i==']'){
                if(st.empty()||st.peek()!='['){
                    sb.append("no\n")
                    break
                }
                else
                    st.pop()
            }
            if(i=='.'){
                if(st.empty()) {
                    sb.append("yes\n")
                    break
                }
                else {
                    sb.append("no\n")
                    break
                }
            }

        }

    }
    println(sb)

}