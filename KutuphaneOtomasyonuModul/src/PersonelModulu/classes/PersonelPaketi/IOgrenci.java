
package PersonelPaketi;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface IOgrenci {
    void ekleme(String ad, String soyad, String telno, String tcno, String adres, String kullaniciAdi, String sifre, String cinsiyet);
    ResultSet listeleme();
    ResultSet ara(String ad);
    void guncelleme(int personel_id, String adi, String soyadi, String telno, String tcno, String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet);
    void silme(int personel_id);
}
