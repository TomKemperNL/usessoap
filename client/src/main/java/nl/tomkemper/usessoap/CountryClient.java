package nl.tomkemper.usessoap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.baeldung.springsoap.client.gen.GetCountryRequest;
import com.baeldung.springsoap.client.gen.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {
    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
        return response;
    }

}
