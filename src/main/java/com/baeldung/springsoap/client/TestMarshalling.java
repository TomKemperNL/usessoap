package com.baeldung.springsoap.client;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;

import javax.xml.transform.stream.StreamResult;

public class TestMarshalling {

    public static void main(String[] args) {
        System.out.println("Fucking marshaller");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(com.baeldung.springsoap.gen.GetCountryRequest.class);


        //dit ding is cursed
        marshaller.marshal(new com.baeldung.springsoap.gen.GetCountryRequest(), new StreamResult(System.out));

    }
}
