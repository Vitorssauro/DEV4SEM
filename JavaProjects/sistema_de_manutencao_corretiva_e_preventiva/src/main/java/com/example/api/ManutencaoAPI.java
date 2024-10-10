package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoAPI {

    public static List<Manutencao> getManutencoes() {
        String json = ApiConnection.getData("Manutencao");
        List<Manutencao> manutencoes = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                // Converter data para LocalDate
                String dataStr = jsonObject.getString("data");
                LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ISO_DATE);

                Manutencao manutencao = new Manutencao(
                    jsonObject.getString("id"),
                    jsonObject.getLong("maquinaID"),
                    data,
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getLong("tempoDeParada"),
                    jsonObject.getString("tecnicoID"),
                    jsonObject.getString("observacoes")
                );
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
}
