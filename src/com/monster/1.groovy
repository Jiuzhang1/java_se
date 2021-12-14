package com.monster

def abc(){
   println("Hello World!")
}



for (j in 0..<3){
    for (i in 0..<10) {
        if (i==5)continue;
        println(j+''+i)
    }
}
def list = [1,2,5,7]
list.each{
    if (it==5) return ;
    println it
}

list.each{val->
    if (val==5) return ;
    println val
}

list.eachWithIndex{it,index->
    if (it==5) return ;
    println "value " + it + " at index " +index
}