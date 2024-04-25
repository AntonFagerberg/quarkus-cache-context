package org.acme;

import io.quarkus.cache.CacheResult;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingsService {


    @CacheResult(cacheName = "test")
    Uni<String> doSomething() {
        return Uni.createFrom().context(c -> {
            System.out.println(c);
            return Uni.createFrom().item("Hello from Quarkus REST");
        });
    }
}
