package com.hashimati.grpc.hello;


import com.hashimati.io.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloRestService
{
    private final HelloServiceChannel helloServiceChannel;
    public HelloRestService(HelloServiceChannel helloServiceChannel)
    {
        this.helloServiceChannel = helloServiceChannel;
    }
    @GetMapping("/")
    public Mono<String> sayHello(@RequestParam(defaultValue = "World") String name)
    {
        return Mono
                .just(helloServiceChannel
                        .sayHello(HelloRequest.newBuilder()
                                .setName(name).build()
                        ).getMessage()
                );
    }
}
