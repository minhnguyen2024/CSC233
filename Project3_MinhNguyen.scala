/*
Project 3
Siam Tahsin Mugdho
Minh Nguyen
*/

import annotation.tailrec;

object Main {
  def main(args: Array[String]): Unit = {
    //Test 1)
    println(strListLen(List("abc", "de", "fghij")));
    println(strListLen(List("hi", "bye", "see ya")));

    //Test 2)
    println(totalStrLen(List("abc", "de", "fghij")));
    println(totalStrLen(List("hi", "bye", "see ya")));

    //Test 3)
    println(generateIsUnderMax(10));
    println(generateIsUnderMax(10)(5));
    println(generateIsUnderMax(10)(15));

    val ls = List(3,6,7,4,5,2)
    println(ls.filter(generateIsUnderMax(5)));
    println(ls.filter(generateIsUnderMax(4)));
    println(ls.map(generateIsUnderMax(5)));

    //Test 4a)
    val a = List(2,3,4)
    println(intReduce( (x:Int, y:Int) => x*y, a));
    println(intReduce( (x:Int, y:Int) => x+y, a));

    //Test 4b)
    println(intReduceAPS( (x:Int, y:Int) => x*y, a));
    println(intReduceAPS( (x:Int, y:Int) => x+y, a));

    //Test 5)
    println(nestedAnyMap[Int, Int]( (x:Int) => x+1, List(List(1,2,3,4,5), List(4,5,6), List(10,12,14,16,18,20,22))));

    //Test 6)
    println(sumOfProducts( List(List(1,2,3),List(4,5),List(6,7,8,9))));
  }
  
  //1)
  def strListLen(ls:List[String]):List[Int] = ls match {
    case Nil => Nil;
    case h::t =>ls.map((x:String)=>x.length);
  }

  //2)
  def totalStrLen(ls:List[String]): Int = ls match{
    case Nil => 0;
    case h::t => (ls.map((x:String)=>x.length)).reduce((a:Int, b:Int) =>a+b);
  }

  //3)
  def generateIsUnderMax(max:Int) = ((x:Int)=>if (x < max) true else false);

  //4a)
  def intReduce(f:(Int, Int) => Int, ls:List[Int]):Int = ls match {
    case h::Nil => h;
    case h::t => f(h, intReduce(f,t));
  }

  //4b)
  def intReduceAPS(f:(Int, Int) => Int, ls:List[Int]):Int = {
      @tailrec def intReduceHelper(f:(Int, Int) => Int, ls:List[Int], accum:Int):Int = ls match {
          case Nil => accum;
          case h::t =>  intReduceHelper(f, t, f(h, accum));
      }
      intReduceHelper(f, ls.tail, ls.head);
  }

  //5)
  def nestedAnyMap[IN,OUT](f: IN=>OUT, ls: List[List[IN]]):List[List[OUT]] = {
    ls.map((nest:List[IN]) => nest.map(f));
  }

  //6)
  def prod(x:Int, y:Int) = {x*y;}
    
  def sum(x:Int, y:Int) ={x+y};
  
  def sumOfProducts(ls: List[List[Int]]): Int = {
    ls.map((nest:List[Int])=> nest.reduce((prod))).reduce(sum);
  }
}
