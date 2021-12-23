
package PersonelPaketi;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        Ogrenci ogrenci = new  Ogrenci();
        //ogrenci.ekleme("Mehmet", "Koçhan", "5445474114", "308202", "Kocaeli/Darıca", "serhatkochan", "12345", "Erkek"); // ekleme
        
        
        /*
        ResultSet resultSet = ogrenci.listeleme();
        try {
            while(resultSet.next()){
                System.out.println(resultSet.getString("adi"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        */ /// listeleme

        
        /*
        ResultSet resultSet = ogrenci.ara("Serhat");
        
        try{
        while(resultSet.next()){
            System.out.println(resultSet.getInt("personel_id"));
            System.out.print(resultSet.getString("adi"));
            System.out.println(resultSet.getString("soyadi"));
        }
        }catch(Exception e){
            System.out.println(e);
        }
        */ // öğrenci arama
        
        // ogrenci.guncelleme(15, "Hüseyin Ahmet", "Angular", "544", "4", "asdas", "ser", "koc", "Erkek"); // güncelleme
        
        // ogrenci.silme(16); // silme
        
        
        //*************Yönetici Bölümü***************///
        /*
        Yonetici yonetici = new Yonetici();
        yonetici.ekleme(15); */ // yonetici ekleme
        
        
        /*
        Yonetici yonetici = new Yonetici();
        ResultSet resultSet = yonetici.listeleme();
        
        try {
            while(resultSet.next()){
                System.out.println(resultSet.getString("adi"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }*/ // Yönetici listeleme
        
        /*
        Yonetici yonetici = new Yonetici();
        ResultSet resultSet = yonetici.ara("Hüseyin Ahmet");
        
        try{
        while(resultSet.next()){
            System.out.println(resultSet.getInt("personel_id"));
            System.out.print(resultSet.getString("adi"));
            System.out.println(resultSet.getString("soyadi"));
        }
        }catch(Exception e){
            System.out.println(e);
        }
        */ // Yönetici Arama
        
        
        /*
        Yonetici yonetici = new Yonetici();
        yonetici.silme(15);
        */ // Yönetici Silme
        
        //Yonetici.calisanSayisiDegistir(10); // calisan sayısı değiştirme
        
        Yonetici.CalisanSayisiKontrol calisanSayisiKontrol = new Yonetici.CalisanSayisiKontrol();
        System.out.println("Calisan sayımız: " + calisanSayisiKontrol.getMax_calisan_sayisi());
        
        
        
        
        
    }
}
