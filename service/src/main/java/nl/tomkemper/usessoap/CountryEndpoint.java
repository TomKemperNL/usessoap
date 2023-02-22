package nl.tomkemper.usessoap;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;
import com.baeldung.springsoap.gen.GetCountryRequest;
import com.baeldung.springsoap.gen.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest req) {
        String name = req.getName();
        Country c = new Country();
        c.setName(name);
        c.setPopulation(999);
        c.setCurrency(Currency.EUR);
        c.setCapital("Hoofdstad!");

        GetCountryResponse resp = new GetCountryResponse();
        resp.setCountry(c);
        return resp;
    }
}
