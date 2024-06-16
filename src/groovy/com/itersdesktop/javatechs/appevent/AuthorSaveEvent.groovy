package com.itersdesktop.javatechs.appevent

import org.springframework.context.ApplicationEvent

class AuthorSaveEvent extends ApplicationEvent {
    String message

    AuthorSaveEvent(Object source, String message) {
        super(source)
        this.message = message
    }
}