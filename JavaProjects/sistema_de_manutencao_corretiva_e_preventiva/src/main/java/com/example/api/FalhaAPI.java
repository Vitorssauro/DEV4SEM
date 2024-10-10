package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FalhaAPI {

    public static List<Falha> getFalhas() {
        String json = ApiConnection.getData("falhas");
        List<Falha> falhas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato da data

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falha falha = new Falha(
                        jsonObject.getString("id"),
                        jsonObject.getLong("maquinaId"),
                        LocalDate.parse(jsonObject.getString("data"), formatter), // Converte para LocalDate
                        jsonObject.getString("problema"),
                        jsonObject.getString("prioridade"),
                        jsonObject.getString("operador")
                );
                falhas.add(falha);
            }
        }
        return falhas;
    }
}
