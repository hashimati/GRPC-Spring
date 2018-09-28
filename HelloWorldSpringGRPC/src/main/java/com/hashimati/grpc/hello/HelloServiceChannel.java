package com.hashimati.grpc.hello;

import com.hashimati.io.HelloRequest;
import com.hashimati.io.HelloResponse;
import com.hashimati.io.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class HelloServiceChannel {
    public HelloResponse sayHello(HelloRequest message){
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse response =  stub.sayHello(message);
        return response;


    }


}
