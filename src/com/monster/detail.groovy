package com.monster

import groovy.json.JsonSlurper

import java.util.concurrent.ConcurrentHashMap

def jsonSlurper = new JsonSlurper()
File file=new File('config.json')
if(!file.exists()){
    println("文件不存在或者路径不正确，请检查！")
    return
}
def config = jsonSlurper.parse(file)
String[] frmTurbNames = ["01#","02#"]
println "config = $config"

def sourceMap = new ConcurrentHashMap<String, Map<String,String>>();
frmTurbNames.eachWithIndex { devId, index ->
    if (sourceMap.get(devId) == null) {
        //如果为null,则表明风机一次都没有连接，或者重新连过，但是redis重启了。
        //new一个map，把通讯中断状态加进去，加进去后return。这样转发就可以取到这几个数了。
        def temp_map = new ConcurrentHashMap<String, String>();
        config.each{ k, v -> temp_map.put(k,v)}
        sourceMap.put(devId, temp_map)

        //println '通讯中断-无数据结构'
    }
}
println("sourceMap="+sourceMap)