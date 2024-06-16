package com.itersdesktop.javatechs.appevent

import grails.transaction.Transactional
import org.springframework.context.ApplicationListener

// https://www.tothenew.com/blog/using-spring-events-in-grails/
@Transactional
class EventListenerService implements ApplicationListener<AuthorSaveEvent> {
    void onApplicationEvent(AuthorSaveEvent event) {
        println "Come here to create 10000 entries"
        (1..10000).each {
            new Author(name:"Madhav", age:23).save()
        }
    }
}