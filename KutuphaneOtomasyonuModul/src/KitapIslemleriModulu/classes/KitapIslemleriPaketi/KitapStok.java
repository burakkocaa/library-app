package KitapIslemleriPaketi;
import java.sql.*;
import VeritabaniPaketi.DBAraKatmani;

public class KitapStok implements IKitapStok{
    
    private static int kutuphaneKitapKapasitesi = 0; // Static ve Private Değişken
    
    public static int getKutuphaneKitapKapasitesi() { // Private Değişkene Erişim {Getter}
        
        if(kutuphaneKitapKapasitesi==0){
            DBAraKatmani dBAraKatmani = new DBAraKatmani();
            Connection connection = dBAraKatmani.baglan();
                
            try {
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("select kitap_kapasitesi from tbl_kapasite");

                while(resultSet.next()){
                    kutuphaneKitapKapasitesi = resultSet.getInt("kitap_kapasitesi");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return kutuphaneKitapKapasitesi;
    }

    
    public static void setKutuphaneKitapKapasitesi(int kapasite) { // Private Değişkene Erişim {Setter}
        
        if(kapasite < 0){
            kapasite = 0;
        }
        
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kapasite SET kitap_kapasitesi='"+kapasite+"'");
            KitapStok.kutuphaneKitapKapasitesi = kapasite;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        dBAraKatmani.baglantiKes();
    }
    
    
    public static boolean kutuphaneKapasitesiKontrol(){ // Static Method
        int kitapSayisi;
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) FROM tbl_kitap");
            
            resultSet.next();
            kitapSayisi = resultSet.getInt(1);
            
            if(kitapSayisi<kutuphaneKitapKapasitesi)
            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    
    @Override
    public void ekleme(String isim, String yazar, String yayinevi, String konu, int adet, int sayfaSayisi) {  // ekleme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_kitap (ismi, yazari, yayinevi, konusu, sayisi, sayfasi) VALUES ('"+isim+"', '"+yazar+"', '"+yayinevi+"', '"+konu+"', '"+adet+"', '"+sayfaSayisi+"')");
             
        } catch (Exception e) {
            System.out.println(e);
        }
        
        dBAraKatmani.baglantiKes();
    }

    
    @Override
    public ResultSet listeleme() {  // listeleme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from tbl_kitap");
            
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        dBAraKatmani.baglantiKes();
        return null;
    }

    
    @Override
    public ResultSet ara(String kitapAdi) {  // arama

        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from tbl_kitap where ismi='"+kitapAdi+"'");
            
            return resultSet;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    public ResultSet ara(int kitap_id){ // method overloading
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from tbl_kitap where kitap_id='"+kitap_id+"'");
 
            return resultSet;
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    
    
    @Override
    public void guncelle(int kitapID, String isim, String yazar, String yayinevi, String konu, int adet, int sayfaSayisi) {  // güncelleme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE tbl_kitap SET ismi='"+isim+"',yazari='"+yazar+"',yayinevi='"+yayinevi+"',konusu='"+konu+"',sayisi='"+adet+"',sayfasi='"+sayfaSayisi+"' WHERE kitap_id='"+kitapID+"'");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }
    public void guncelle(int kitapID,int adet){
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE tbl_kitap SET sayisi='"+adet+"' WHERE kitap_id='"+kitapID+"'");
        } catch (Exception e) {
        }
    }

    
    @Override
    public void silme(int kitapID) {  // silme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE from tbl_kitap WHERE kitap_id='"+kitapID+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }
}
