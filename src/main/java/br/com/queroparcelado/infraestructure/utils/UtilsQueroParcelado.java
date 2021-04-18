package br.com.queroparcelado.infraestructure.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilsQueroParcelado {

    public static LocalDate converterMilisegundosLocalDate(String dateToConvert) {
        Date data = new Date(Long.parseLong(dateToConvert));
        return data.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDate converterDateLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDate converterDateLocalDateComMilisegundos(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
