package com.hashimati;

import com.hashimati.io.HelloRequest;
import com.hashimati.io.HelloResponse;
import com.hashimati.io.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class hello extends HelloServiceGrpc.HelloServiceImplBase {
    public hello(){

        System.out.println("Hello Service is ready");
    }
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
       // super.sayHello(request, responseObserver);
        responseObserver.onNext(HelloResponse.newBuilder()
                .setMessage("Hi " + request.getName())
                .build());
        responseObserver.onCompleted();
    }
}
