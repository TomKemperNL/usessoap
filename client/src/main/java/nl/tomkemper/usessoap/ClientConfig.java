package nl.tomkemper.usessoap.client;

import com.baeldung.springsoap.client.gen.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;

@Configuration
public class ClientConfig {

    @Bean
    public CountryClient countryClient() {

        //even oppassen, we draaien de service en de client in 1 spring-context, terwijl ze andere serializers nodig hebben:S
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();



        CountryClient client = new CountryClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}