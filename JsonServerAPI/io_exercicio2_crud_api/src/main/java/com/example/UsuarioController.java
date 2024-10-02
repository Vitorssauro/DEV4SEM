package com.example;

import com.example.Usuario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public void read() {
        try {
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status != 200) {
                throw new Exception("Erro de Conexão");
            }
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String linha;

            StringBuffer content = new StringBuffer();

            while ((linha = br.readLine()) != null) {
                content.append(linha);
            }

            br.close();

            JSONArray dadosUsuarios = new JSONArray(content.toString());

            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuarioJson.getString("id"),
                        usuarioJson.getString("nome"),
                        usuarioJson.getInt("idade"),
                        usuarioJson.getString("endereco")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(usuarios.toString());
    }

    public void createUser(Usuario usuario) {
        try {
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            // informações necessárias para o POST
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            // enviar dos dados para a API
            try (BufferedReader bw = new BufferedReader(
                    new OutputStreamWriter(con.getOutputStream(), "UTF-8"))) {
                bw.write(usuarioJson.toString());
                bw.flush();
            }

            // Verificar o status da resposta
            int status = con.getResponseCode();
            if (status!= HttpURLConnection.HTTP_CREATED) {
                throw new Exception("Erro ao Criar Usuário"+status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
