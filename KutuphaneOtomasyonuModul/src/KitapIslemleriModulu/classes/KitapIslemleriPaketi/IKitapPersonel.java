package KitapIslemleriPaketi;
import java.sql.ResultSet;

public interface IKitapPersonel extends IKitapPersonelBilgisi{ // kalıtım
    void ekleme();
    ResultSet listeleme();
    ResultSet ara();
    void guncelle();
    void silme();
}
