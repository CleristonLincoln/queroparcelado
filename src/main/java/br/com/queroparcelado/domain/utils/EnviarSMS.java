package br.com.queroparcelado.domain.utils;

import org.springframework.web.client.RestTemplate;

public class EnviarSMS {

    public static void sendSMS( String numberPhone, String password) {

        String url = "https://api.smsdev.com.br/send?key=";

        String type = "&type=9&number=";

        String ACCESS_KEY = "0V31IY5DQZP15JOOM5PXIVDC";

        String sendUrl = url + ACCESS_KEY + type + numberPhone +
                "&msg=Olá sua validação de telefone do queroparcelado é: " + password;

        RestTemplate restTemplate = new RestTemplate();
         restTemplate.postForEntity(sendUrl,null, null);
    }
}
