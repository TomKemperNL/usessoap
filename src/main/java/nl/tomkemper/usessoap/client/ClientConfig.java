package nl.tomkemper.usessoap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientConfig {

    @Bean
    public CountryClient countryClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.baeldung.springsoap.client.gen");
        marshaller.setPackagesToScan("com.baeldung.springsoap.client.gen");

        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
