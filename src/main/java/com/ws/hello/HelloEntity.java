package com.ws.hello;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class HelloEntity {
    private String message;

    public HelloEntity() {
        // Needed for JAXB / JSON-B
    }

    public HelloEntity(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
