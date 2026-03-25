package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final  String URL ="jbc:sqlite:adenda.db";

    public static Connection conectar(){
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
    public static void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS contatos("
                +" id INTEREGER PRIMARY KEY AUTOINCREMENT,"
                +" nome TEXT NOT NULL,"
                + "telefone TEXT"
                + ");";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement()){
            stmt.execute(sql);

        }catch (SQLException e){
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

}
