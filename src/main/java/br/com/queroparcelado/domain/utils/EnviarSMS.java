package br.com.queroparcelado.domain.utils;

import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class EnviarSMS {

    public static String sendSMS( String numberPhone) {

        String url = "https://api.smsdev.com.br/send?key=";

        String type = "&type=9&number=";

        String ACCESS_KEY = "0V31IY5DQZP15JOOM5PXIVDC";

        int min = 1000;
        int max = 9999;

        int password = new Random().nextInt((max - min) + 1) + min;

        System.out.println(numberPhone);

        String sendUrl = url + ACCESS_KEY + type + numberPhone +
                "&msg=Olá sua validação de telefone do queroparcelado é: " + password;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(sendUrl,null, null);
       return String.valueOf(password);
    }

}
