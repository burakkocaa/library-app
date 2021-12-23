
package PersonelPaketi;

import java.sql.ResultSet;

public interface IYonetici extends IKalitimBilgileri{
    void ekleme(String adi, String soyadi, String telno, String tcno, String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet);
    ResultSet listeleme();
    ResultSet ara(String ad);
    void guncelleme(int personel_id, String adi, String soyadi, String telno, String tcno, String adresi, String kullaniciadi, String kullanicisifre, String cinsiyet);
    void silme(int personel_id);
}
