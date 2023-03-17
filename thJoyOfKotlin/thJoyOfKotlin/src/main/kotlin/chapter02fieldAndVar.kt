// field and var
fun main(){
    //var name="Frank 현석 Oh"
    val name:String by lazy(::getname)
    println("안녕")
    val name2:String by lazy{name}
    println("안녕2")
    println(name)
    println(name2)
    println(name)
    println(name2)
}
fun getname():String{
    println("이름 계산 중...")   //이부분은 처음 한번만 출력되고 이후론 출력이 없음
    return "Frank 현석 Oh"
}







