def retry(def funName, def fun, def t, def w){
    println("retry ${funName} ${t} ${w}ms")

    def ins = null;
    t = t>0?t:Integer.MAX_VALUE;
    (1..t).any{ct->
        try{
            println("try ${funName} ${ct}")
            ins = monster();
            println "小姜"
            return true;
        }catch(e){
            e.printStackTrace()
        }
        println("${funName} retry ${w}ms")
        Thread.currentThread().sleep(w);
    }
    println "老姜"
    return ins;

}
def monster(){
    return new File("tmp.csv").text
}
retry("init",println("hello"),-1,10000)
while (true) {
    Thread.currentThread().sleep(2000);
    println "Hello World!"
}
println(retry("init",println("hello"),-1,10000))