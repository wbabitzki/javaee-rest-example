package com.ws.hello;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldResourceIT {
    private WebTarget tut;
    static final String SERVICE_URI = "http://localhost:8080/HelloWorld/rest/hello/";

    @Before
    public void init() {
        this.tut = ClientBuilder.newClient().target(SERVICE_URI);
    }

    @Test
    public void testHelloAsText() {
        final Response response = this.tut //
            .path("asText") //
            .request(MediaType.TEXT_PLAIN_TYPE) //
            .get();
        final String result = response.readEntity(String.class);
        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(MediaType.TEXT_PLAIN_TYPE));
        assertThat(result, is("Hello world, again and again!!!"));
    }

    @Test
    public void testHelloAsJsonObject() {
        final Response response = this.tut.path("asJsonObject") //
            .request(MediaType.APPLICATION_JSON) //
            .get();
        final JsonObject result = response.readEntity(JsonObject.class);
        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(MediaType.APPLICATION_JSON_TYPE));
        assertThat(result.getString("result"), is("Hello world, again and again!!!"));
    }

    @Test
    public void testHelloAsEntityPerJson() {
        final Response response = this.tut.path("asEntityPerJson") //
            .request(MediaType.APPLICATION_JSON) //
            .get();
        final HelloEntity result = response.readEntity(HelloEntity.class);
        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(MediaType.APPLICATION_JSON_TYPE));
        assertThat(result.getMessage(), is("Hello world, again and again!!!"));
    }

    @Test
    public void testHelloAsEntityPerXML() {
        final Response response = this.tut.path("asEntityPerXml") //
            .request(MediaType.APPLICATION_XML) //
            .get();
        final HelloEntity result = response.readEntity(HelloEntity.class);
        assertThat(response.getStatus(), is(200));
        assertThat(response.getMediaType(), is(MediaType.APPLICATION_XML_TYPE));
        assertThat(result.getMessage(), is("Hello world, again and again!!!"));
    }
}
