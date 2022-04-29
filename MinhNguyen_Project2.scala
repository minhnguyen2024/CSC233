def count(ls:List[Any], n:Any):Int = {
    if (ls == Nil){
        0;
    } else {
        if (ls.head == n){
            1 + count(ls.tail,n);
        } else {
            count(ls.tail,n);
        }
    }
}

def countPatternMatching(ls:List[Any], n:Any):Int = ls match{
    case Nil => 0;
    case h::t => if (h == n) 1 + countPatternMatching(t, n) else countPatternMatching(ls.tail,n);
}

def getLess(ls:List[Int], n:Int):List[Int] = {
    if (ls == Nil){
        List();
    } else {
        if (ls.head < n){
            ls.head::getLess(ls.tail, n);
        } else{
            getLess(ls.tail, n);
        }
    }
}

def getLessPatternMatching(ls:List[Int], n:Int):List[Int] = ls match {
    case Nil => List();
    case h::t =>
    if (h < n){
        h::getLessPatternMatching(t, n);
    } else{
        getLessPatternMatching(t, n);
    }
}

def getGreaterEq(ls:List[Int], n:Int):List[Int] = {
    if (ls == Nil){
        List();
    } else {
        if (ls.head >= n){
            ls.head::getGreaterEq(ls.tail, n);
        } else{
            getGreaterEq(ls.tail, n);
        }
    }
}

def getGreaterEqPatternMatching(ls:List[Int], n:Int):List[Int] = ls match {
    case Nil => List();
    case h::t =>
    if (h >= n){
        h::getGreaterEqPatternMatching(t, n);
    } else{
        getGreaterEqPatternMatching(t, n);
    }
}

def findLargest(ls:List[Int]):Int = ls match{
    case h::Nil => h;
    case h::t=>
    val maxOfTail = findLargest(t);
    if (h > maxOfTail)
        h;
    else{
        findLargest(t);
    }
}

def order(ls:List[Int]):List[Int] = ls match{
    case Nil=> List();
    case h::t=> order(getLess(t, h))++(h::order(getGreaterEq(t, h)));
}











