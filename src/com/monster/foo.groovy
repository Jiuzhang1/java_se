package com.monster

import groovy.util.logging.Slf4j

@Grapes([
        @Grab(group='ch.qos.logback', module='logback-classic', version='1.0.13')
])

//
// Classes
// =======

@Slf4j
class StandardGreeting {

    def greet() {
        log.trace "Hello world"
        log.debug "Hello world"
        log.warn  "Hello world"
        log.info  "Hello world"
        log.error "Hello world"
    }
}
def runner = new StandardGreeting()

runner.greet()