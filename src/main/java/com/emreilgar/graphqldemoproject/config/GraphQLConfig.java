package com.emreilgar.graphqldemoproject.config;


import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {
    /**Bu kod parçası, GraphQL schema'nızın çalışma zamanı yapılandırmasını yapılandırmak için kullanılır.
     * Spring Framework kullanılarak yapılan bir GraphQL uygulamasında, RuntimeWiringConfigurer arayüzünü
     * uygulayan bir bean tanımlayarak bu yapılandırmayı gerçekleştirebilirsiniz.
     *
     *  implementation 'com.graphql-java:graphql-java-extended-scalars:21.0'  eklemek gerekiyor.*/
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date);
    }
}
