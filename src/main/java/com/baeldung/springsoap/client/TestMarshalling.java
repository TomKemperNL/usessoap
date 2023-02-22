package com.baeldung.springsoap.client;

import com.baeldung.springsoap.client.gen.Country;
import com.baeldung.springsoap.client.gen.GetCountryRequest;
import com.baeldung.springsoap.client.gen.GetCountryResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;

public class TestMarshalling {

    public static void main(String[] args) {
        System.out.println("Fucking marshaller");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(GetCountryRequest.class);
        marshaller.setClassesToBeBound(GetCountryResponse.class);
        marshaller.setClassesToBeBound(Country.class);

        StringResult blergh = new StringResult();
        //dit ding is cursed
        marshaller.marshal(new GetCountryRequest(), blergh);
        System.out.println(blergh);
    }
}
