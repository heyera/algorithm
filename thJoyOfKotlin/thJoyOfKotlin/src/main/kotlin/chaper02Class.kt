import java.time.Instant

/*fun main(){
    val person=Person("bob")
    println(person.name)
    println(person.name.equals("bob"))
}*/


//data를 사용하면 게터와 세터 자동으로 생성해줌, 또한 equals와 hashCode또한 생성해줌
data class Person(val name:String, val registered: Instant = Instant.now())
fun show(persons:List<Person>){
    for((name,date)in persons)
        println(name+"'s registrantion date: " + date)
}
fun main(args: Array<String>){
    val persons=listOf(Person("Mike"),Person("Paul" ))
    show(persons)

}