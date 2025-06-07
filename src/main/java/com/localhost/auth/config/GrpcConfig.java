package com.localhost.auth.config;

import com.localhost.customer.CustomerClientServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;
import org.springframework.grpc.client.ImportGrpcClients;

@ImportGrpcClients(target = "customer", basePackages = {"com.localhost.customer"})
@Configuration
public class GrpcConfig {

    @Bean
    CustomerClientServiceGrpc.CustomerClientServiceBlockingStub stub(GrpcChannelFactory grpcChannelFactory) {
        return CustomerClientServiceGrpc.newBlockingStub(grpcChannelFactory.createChannel("customer"));
    }
}
