package br.com.queroparcelado.domain.utils;

import java.util.Random;

public class GerarSenhaUtil {

    public static String gerarSenha(){
        Random random = new Random();

        Integer[] pw = new Integer[1];
        pw[0] = random.nextInt(9999);
        return Integer.toString(pw[0]);
    }

}
