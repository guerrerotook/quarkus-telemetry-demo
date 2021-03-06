package com.microsoft.cse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.opentelemetry.api.trace.Span;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Span.current().setAttribute("mycustomdimension", "myvalue1");
        String traceId = Span.current().getSpanContext().getTraceId();
        String spanId = Span.current().getSpanContext().getSpanId();
        return "Hello RESTEasy TraceId " + traceId + " SpanId " + spanId;
    }
}