package com.sandari.rain.configurations;


import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.sandari.rain.resolvers.MyGraphQLResolver;

import java.io.IOException;
import java.io.InputStreamReader;

@Configuration
public class GraphQLConfig {

    private final MyGraphQLResolver myGraphQLResolver;
    private final ResourceLoader resourceLoader;

    @Autowired
    public GraphQLConfig(MyGraphQLResolver myGraphQLResolver, ResourceLoader resourceLoader) {
        this.myGraphQLResolver = myGraphQLResolver;
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public GraphQL graphQL() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:schema.graphql");
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(new InputStreamReader(resource.getInputStream()));
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder
                        .dataFetcher("hello", environment -> myGraphQLResolver.hello(environment.getArgument("userId")))
                        .dataFetcher("getUser", environment -> myGraphQLResolver.getUser(environment.getArgument("userId"))))
                .type("Mutation", builder -> builder
                        .dataFetcher("createUser", environment -> myGraphQLResolver.createUser(environment.getArgument("username"), environment.getArgument("password"))))
                .build();
    }
}
