package io.sandbox;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.sandbox.grpc_client.TinkoffInvestService;
import io.sandbox.grpc_client.TinkoffStub;
import io.sandbox.service.CommandServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TinkoffApiApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(TinkoffApiApplication.class, args);


        var server = ServerBuilder.forPort(9090)
                .addService(new CommandServiceImpl(new TinkoffInvestService(new TinkoffStub())))
                .build();

        server.start();
        server.awaitTermination();
    }
}