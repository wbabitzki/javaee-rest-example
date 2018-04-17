# Restful web service with Java EE 8.0 system tests

A simple example of REST service

This service is realized based on the microservice concept with a single provided dependency *javax.javaee-api*.

System tests utilize following technologies:
* JAX-RS 2.1
* JAXB
* JSON-B

For testing the HelloWord REST service is deploying on Payara Container started with Docker for the *integration-test* maven phase. 
The tests confirm that service provide responses in the plain text, XML and JSON (with and without JSON Binding) Media Type   