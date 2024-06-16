package com.itersdesktop.javatechs.appevent

class DemoController {
    def grailsApplication

    def withSpringEvent() {
        AuthorSaveEvent authorSaveEvent = new AuthorSaveEvent(new Object(), "Call test spring events")
        grailsApplication.mainContext.publishEvent(authorSaveEvent)
        render "<h2>Records saving has been Initialized</h2>"
    }

    def withOutSpringEvent() {
        (1..10000).each {
            new Author(name: "Madhav", age: 23).save()
        }
        render "<h2>All Records has been saved</h2>"
    }
    def index() {
        def time = System.nanoTime()
        withSpringEvent()
        time = (System.nanoTime() - time) / 1000000.0
        log.debug("It took ${time}ms to create 10,000 authors using withSpringEvent().")
        println("It took ${time}ms to create 10,000 authors using withSpringEvent().")
        time = System.nanoTime()
        withOutSpringEvent()
        time = (System.nanoTime() - time) / 1000000.0
        log.debug("It took ${time}ms to create 10,000 authors using withOutSpringEvent().")
        println("It took ${time}ms to create 10,000 authors using withOutSpringEvent().")
    }
}
