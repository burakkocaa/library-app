package VeritabaniPaketi;

import java.sql.*;

public class DBAraKatmani {
    private String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=db_kutuphane;user=serhat_murat;password=1234";
    Connection connection;
    
    public Connection baglan(){
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionString);
            System.out.println("Baglanti Basarili.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
    public void baglantiKes(){
        try {
            connection.close();
            System.out.println("Baglanti Kesildi.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
