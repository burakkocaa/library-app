
package PersonelPaketi;

import VeritabaniPaketi.DBAraKatmani;
import java.sql.*;
import java.util.ArrayList;


public class Ogrenci implements IOgrenci{
    private static String gorev = "Öğrenci";

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }
    
    

    @Override
    public void ekleme(String adi, String soyadi, String telno, String tcno, String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        
        Connection connection = dBAraKatmani.baglan();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO tbl_personel (adi, soyadi, telno, tcno, gorevi, adresi, kullaniciadi, kullanicisifre, cinsiyet) VALUES ('"+adi+"', '"+soyadi+"', '"+telno+"', '"+tcno+"', '"+gorev+"', '"+adresi+"', '"+kullaniciadi+"', '"+kullanicisifre+"', '"+cinsiyet+"' )");

        } catch (Exception e) {
            System.out.println(e);
        }

        dBAraKatmani.baglantiKes();
        
    }

    @Override
    public ResultSet listeleme() {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_personel");
            
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public ResultSet ara(String tcno) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_personel where tcno='"+tcno+"'"); 
            
            return resultSet;

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    public ResultSet ara(String adi, String soyadi){ // method overloaing
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_personel where gorevi='Öğrenci' and adi='"+adi+"' and soyadi='"+soyadi+"'");
            return  resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return  null;
    }
    
    @Override
    public void guncelleme(int personel_id, String adi, String soyadi, String telno, String tcno, String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update tbl_personel set adi='"+adi+"' , soyadi='"+soyadi+"' , telno='"+telno+"' , tcno='"+tcno+"' , adresi='"+adresi+"' , kullaniciadi='"+kullaniciadi+"' , kullanicisifre='"+kullanicisifre+"' , cinsiyet='"+cinsiyet+"' where personel_id='"+personel_id+"'");
         } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }

    @Override
    public void silme(int personel_id) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from tbl_personel where personel_id='"+personel_id+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }
    
}
