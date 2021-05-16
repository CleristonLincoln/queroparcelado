package br.com.queroparcelado.core;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SMSConfig {

    public void sendSMS( String numberPhone, String password){

        String url = "https://api.smsdev.com.br/send?key=";
        //  String url = "Enviou o sms - ";

        String accessKey = "0V31IY5DQZP15JOOM5PXIVDC";
        String type = "&type=9&number=";


        System.out.println(url + accessKey + type + numberPhone + "&msg=" + password );

        String sendUrl = url + accessKey + type + numberPhone + "&msg=" + password;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(sendUrl,null, null);

    }

}
