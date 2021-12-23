
package PersonelPaketi;
import VeritabaniPaketi.DBAraKatmani;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class Yonetici implements IYonetici{
    
    static class CalisanSayisiKontrol{ // inner class kullan
        private int max_calisan_sayisi;


        public int getMax_calisan_sayisi() {
            
            return max_calisan_sayisi;
        }

        public void setMax_calisan_sayisi(int max_calisan_sayisi) { // getterr setter fonksiyonlarına örnek göster
                // veri tabanındaki max_yonetici_sayisi verisini değiştirecek
            DBAraKatmani dBAraKatmani = new DBAraKatmani();
            Connection connection = dBAraKatmani.baglan();

            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("update tbl_kapasite set calisan_kapasitesi='"+max_calisan_sayisi+"'");
             } catch (Exception e) {
                System.out.println(e);
            }
            dBAraKatmani.baglantiKes();
                this.max_calisan_sayisi = max_calisan_sayisi;
        }
        
        
        public CalisanSayisiKontrol(){ // constructor kullan
                DBAraKatmani dBAraKatmani = new DBAraKatmani();
                Connection connection = dBAraKatmani.baglan();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from tbl_kapasite");
                    while(resultSet.next()){
                         this.max_calisan_sayisi = resultSet.getInt("calisan_kapasitesi");
                    }


                } catch (Exception e) {
                    System.out.println(e);
                }
                dBAraKatmani.baglantiKes();
        }
    }
    
    
    @Override
    public void ekleme(String adi, String soyadi, String telno, String tcno, String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try { // "INSERT INTO tbl_personel (adi, soyadi, telno, tcno, gorevi, adresi, kullaniciadi, kullanicisifre, cinsiyet) VALUES ('"+adi+"', '"+soyadi+"', '"+telno+"', '"+tcno+"', '"+gorev+"', '"+adresi+"', '"+kullaniciadi+"', '"+kullanicisifre+"', '"+cinsiyet+"' )"
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO tbl_personel (adi, soyadi, telno, tcno, gorevi, adresi, kullaniciadi, kullanicisifre, cinsiyet) VALUES ('"+adi+"', '"+soyadi+"', '"+telno+"', '"+tcno+"', 'Çalışan', '"+adresi+"', '"+kullaniciadi+"', '"+kullanicisifre+"', '"+cinsiyet+"' )");
            
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
            ResultSet resultSet = statement.executeQuery("select * from tbl_personel where gorevi='Çalışan'");
            
            return resultSet;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        
    }

    @Override
    public ResultSet ara(String adi) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from tbl_personel where gorevi='Çalışan' and adi='"+adi+"'"); 
            
            return resultSet;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    

    @Override
    public void guncelleme(int personel_id, String adi, String soyadi, String telno, String tcno,String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet) {
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update tbl_personel set adi='"+adi+"' , soyadi='"+soyadi+"' , telno='"+telno+"' , tcno='"+tcno+"' , gorevi='Çalışan' , adresi='"+adresi+"' , kullaniciadi='"+kullaniciadi+"' , kullanicisifre='"+kullanicisifre+"' , cinsiyet='"+cinsiyet+"' where personel_id='"+personel_id+"'");
         } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }

    @Override
    public void silme(int personel_id) {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.silme(personel_id);
    }
    
    @Override
    public void programiKapa() {
        System.exit(0);
    }
    public static void maxCalisanSayisiDegistir(int sayi){ // static metod kullan
        CalisanSayisiKontrol calisanSayisiKontrol = new CalisanSayisiKontrol();
        calisanSayisiKontrol.setMax_calisan_sayisi(sayi);
    }
    public static void maxCalisanSayisiDondur(){
        CalisanSayisiKontrol calisanSayisiKontrol = new CalisanSayisiKontrol();
        calisanSayisiKontrol.getMax_calisan_sayisi();
        
    }
    public static int calisanSayisiDondur(){
                DBAraKatmani dBAraKatmani = new DBAraKatmani();
                Connection connection = dBAraKatmani.baglan();
                
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select count(*) from tbl_personel");
                    
                    resultSet.next();
                    int rowCount = resultSet.getInt(1);
                    return rowCount;

                } catch (Exception e) {
                    System.out.println(e);
                }
                dBAraKatmani.baglantiKes();
                return 0 ;
    }
    
}