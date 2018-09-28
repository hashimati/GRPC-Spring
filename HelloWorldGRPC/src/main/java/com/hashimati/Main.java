package com.hashimati;
import io.grpc.ServerBuilder;
import java.io.IOException;
public class Main {
    public static void main(String... args) throws IOException, InterruptedException {
        System.out.println("The server is staring");
        ServerBuilder.forPort(8080)
                .addService(new hello())
                .build()
                .start()
                .awaitTermination();
        System.out.println("End!");
    }
}
