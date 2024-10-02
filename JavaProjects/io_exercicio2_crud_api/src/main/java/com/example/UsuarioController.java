package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            // estabeler conexão
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // verificar status da conexão
            int status = con.getResponseCode();
            if (status != 200) {// diferente de 200 lançar uma exception
                throw new Exception("Erro de Conexão");
            }
            // gravar os dados da api na memoria
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String linha;
            // converter em um arquivo de texto(string)
            StringBuffer content = new StringBuffer();
            // Lê a resposta da API linha por linha
            while ((linha = br.readLine()) != null) {
                content.append(linha);
            }
            br.close();// fecha a conexão
            // converter o arquivo de texto para dados da classe usuario
            JSONArray dadosUsuarios = new JSONArray(content.toString());

            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuarioJson.getString("id"), // id
                        usuarioJson.getString("nome"), // nome
                        usuarioJson.getInt("idade"), // idade
                        usuarioJson.getString("endereco") // endereco
                ));
            }

            System.out.println(usuarios.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(Usuario usuario) {
        try {
            // Definir a URL para o endpoint da API de criação de usuários
            url = new URL("http://localhost:3000/usuarios");

            // Estabelecer a conexão
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true); // Habilita o envio de dados no corpo da requisição

            // Criar o JSON do objeto Usuario
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("id", usuario.getId());
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            // Enviar os dados do usuário para a API
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(con.getOutputStream(), "UTF-8"))) {
                writer.write(usuarioJson.toString());
                writer.flush();
            }

            // Verificar o status da resposta
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // HTTP 201 Created
                throw new Exception("Erro ao criar usuário: " + status);
            }

            // Ler a resposta (opcional, dependendo do retorno da API)
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linha;
            StringBuffer responseContent = new StringBuffer();
            while ((linha = br.readLine()) != null) {
                responseContent.append(linha);
            }
            br.close();

            // Exibir resposta
            System.out.println("Usuário criado com sucesso: " + responseContent.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createUser(Usuario usuario) {
        // estabelecer conexão
        try {
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            // informações necessárias para o post
            // criando o Objeto Json
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());

            // enviar dos dados para a API
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(con.getOutputStream(), "UTF-8"))) {
                bw.write(usuarioJson.toString());
                bw.flush();
            }
            // Verificar o status da resposta
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // HTTP 201 Created
                throw new Exception("Erro ao criar usuário: " + status);
            }

            System.out.println("Usuario Cadastrado com Sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
