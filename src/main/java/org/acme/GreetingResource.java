package org.acme;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingsService greetingsService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        var uni = greetingsService.doSomething();

        return Uni.createFrom().emitter(em -> uni.subscribe().with(Context.of("hello", "world"), em::complete, em::fail));
    }
}
