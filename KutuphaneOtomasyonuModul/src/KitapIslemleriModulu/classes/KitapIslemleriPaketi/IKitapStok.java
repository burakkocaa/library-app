package KitapIslemleriPaketi;
import java.sql.ResultSet;

public interface IKitapStok {
    void ekleme(String isim, String yazar, String yayinevi, String konu, int adet, int sayfaSayisi);
    ResultSet listeleme();
    ResultSet ara(String kitapAdi);
    void guncelle(int kitapID, String isim, String yazar, String yayinevi, String konu, int adet, int sayfaSayisi);
    void silme(int kitapID);
}
