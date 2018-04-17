package com.ws.hello;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("hello")
public class HelloWorldResource {
    private static final String HELLO_WORLD = "Hello world, again and again!!!";

    @GET
    @Path("/asText")
    @Produces({ MediaType.TEXT_PLAIN })
    public String hello() {
        return HELLO_WORLD;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/asJsonObject")
    public JsonObject helloAsJsonObject() {
        return Json.createObjectBuilder() //
                .add("result", HELLO_WORLD) //
                .build();
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML })
    @Path("/asEntityPerXml")
    public HelloEntity helloAsEntityPerXml() {
        return new HelloEntity(HELLO_WORLD);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/asEntityPerJson")
    public HelloEntity helloAsEntity() {
        return new HelloEntity(HELLO_WORLD);
    }
}
