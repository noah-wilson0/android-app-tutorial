package com.noah.viewbindingtest1

import java.lang.Exception
import java.util.Scanner
import kotlin.math.max
import kotlin.random.Random
//강의 url: https://www.inflearn.com/course/%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%AC%B8%EB%B2%95%EC%B4%9D%EC%A0%95%EB%A6%AC-1%EC%8B%9C%EA%B0%84/dashboard
const val num=20  //top level 상수  / main보다 우선해서 컴파일된다.
fun main() {
    println("-hello world-")
    println("Hello world")
    println("Hello world")

    //var 는 변수
    println("var 이란")
    var i : Int =10;
    var ii : String ="십"
    var iii : Double = 10.10
    println(i)
    println(ii)
    println(iii)
    //val는 상수
    println("val 이란")
    val j : Int =100
    println(j)
    //top level 상수 출력하기
    println("top level 상수 출력하기")
    println(num)

    var k=10
    var kk=20L
    kk=i.toLong()  //업 캐스팅

    var name ="10"
    k=name.toInt()

    //String에 대해서..
    println("String에 대해서..")
    var name2 = "hello"
    println(name2.uppercase())
    println(name2.lowercase())

    print("문자열 결합하는법:")
    println("안녕은 영어로 ${name2}입니다.")

    //max, min
    println("max, min 사용법")
    var a :Int = 10
    var aa : Int =20
    println(max(a,aa))
    println(Math.max(a,aa))
    println(kotlin.math.max(a,aa)) //kotlin은 kotlin.math.max()함수를 사용하는것을 권장한다.


    //random 사용하기
    println("random 사용하기")
    val randomNumber = Random.nextInt(0,100) //0~99
//    val randomNumber = Random.nextDouble(0.0,1.0) //0.0~ 0.9

    val reader = Scanner(System.`in`)  //백스페이스 사용하여 in을 사용할수있음

    //조건문
    println("조건문 사용하기")
    val x=5
    var result = if (x>5){
        "5보다 크다"
    } else if (x<10){
        "10보다 작다"
    }
    else{
        "!!!"
    }
    println(result)
    //삼항 연산자
    println("삼항 연산자")
    //자바에서 사용하던.. boolean result =x>10? true: false를
    var result1 = if (x>10) true else false
    println(result1)

    //반복문
    println("반복문")
    val items = listOf<Int>(1,2,3,4,5) //listOf는 수정이 불가능한 리스트

    for(item in items){
        println(item)
    }
    for(i in 0..(items.size-1)){
        println(items[i])
    }
    //List
    println("List")
    val Lists  = mutableListOf<Int>(1,2,3,4,5)  //mutableListOf는 수정가능한 리스트 Java에서 쓰던 ArrayList느낌이다.
    Lists.add(6)
    Lists.remove(3)

    //배열array
    println("array")
    val arrays = arrayOf(1,2,3)

    try {
        val array=arrays[4]
    }catch (e: Exception){
        println(e.message)
    }
    //null safety
    println("null safety")

    var x2:String? = null  //kotlin은 ?를 써야 null사용가능하다.

    x2="인프런"
    x2= null

    var x3: String = ""
    //방법1
    if (x2 != null) {  //null 체크 해야된다.
        x3=x2
    }
    //방법2
    //x3=x2!! //임의로 개발자가 null이 아님을 보증하므로 오류나면 개발자 책임이다.

    //방법3
    x2?.let { //null이 아니라면 이 블럭을 실행하자
        x3=x2
    }

    //함수
    println("함수")

    println(sum(a=1,b=2))

    //클래스
    println("class")
    val john=Person("Jhon",20)
    println(john.name) //private val name :String으로 바꾸면 이 부분은 사용불가
    println(john.age)
    john.age=23
    //getter, setter
    println("getter, setter")
    val john2=Person("Jhon",23)
    println(john)
    println(john2)
    //class 앞에 data를 쓰지않은 경우.
    println(john==john2) //false
    //출력은?
//    com.noah.viewbindingtest1.Person@548e7350
//    com.noah.viewbindingtest1.Person@1a968a59

// class Person앞에 data를 붙이게 되면 true가 출력된다. 또한 toSting 재정의를 안해도
    //출력이 이렇게 나온다
//    Person(name=Jhon, age=23)
//    Person(name=Jhon, age=23)
//    john.hobby="ddd"   //아래 Person클래스의 hobby 변수를  private set으로 설정하면 클래스 외부에서 설정이 불가능함
    john.some()
    println("메서드 some을 사용하면?${john.age}")
    //getter, setter 제어
    println("getter, setter 제어")
    println(john.hobby) //172번줄 참고

    //상속
    println("상속은 main아래 Animal class 참고")

    //인터페이스
    println("interfaces는 아래 Drawable인터페이스를 참고후, Dog class 참고")

    //타입 체크
    println("타입 체크")
    val dog :Animal=Dog()
    val cat=Cat()

    if (dog is Dog){  //타입 체크는 is로 한다.
        println("멍멍이")
    }
    //강제 타입 변환은 as를 쓴다 ex) cat as Dog

    //제네릭
    println("제네릭은 아래 제네릭 클래스 참고")
    val box= Box(10)  //제네릭으로 <T>를 해주었기 때문에 Box 클래스의 value변수가 Int라는것을 명시해주었다.
    val box2=Box("dfdfddf")

    println(box.value)
    //콜백 함수(고차 함수)
    println("콜백 함수는 아래 myFunc함수 참고")
    myFunc{  //매개변수가 함수 하나만 있을경우 () 생략 가능
        println("함수 호출")
    }
//    myFunc(10){  //이런 구조를 람다 함수라고 한다.
//        println("함수 호출")
//    }
    //코루틴 정지함수 suspend
    println("정지함수 suspend")

}
fun sum(a:Int,b:Int,c:Int=0) : Int{  //return type을 int로 한것
    return a+b+c
}
//fun sum(a:Int,b:Int) : Int= a+b //이렇게 로도 가능

class Person(val name :String,var age:Int){  //자바와 다르게 생성자를 바로 클래스의 파라미터로써 붙여쓸수있다.

    var hobby="축구"
//        private set
    private set
        get() = "취미 : $field"

    init {
        println("init")
    }
    fun some(){  //메소드
        hobby ="농구"
        age=100
    }
}

//인터 페이스
interface Drawable{
    fun draw()
}

//상속
abstract class Animal{

    open fun move(){
        println("이동")
    }
}
class Dog : Animal(),Drawable{  //인터페이스는 소괄호가 없어도 되고 뒤에 ,를 찍으며 계속할 수 있다.
    //override하려면.. 위에 fun move()를 open fun move()로 해야한다.
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}

class Cat : Animal(){
    override fun move() {
        println("살금")
    }
}
//상속 2
open class Person2

class Superman : Person2()  //상속은 open을 붙여야한다.

//제네릭
class Box<T> (var value: T){

}
//콜백 함수
fun myFunc(callBack: ()-> Unit){
    println("함수 시작!!!")
    callBack()
    println("함수 끝!!!")
}

