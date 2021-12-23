package KitapIslemleriPaketi;
import java.sql.*; 
import VeritabaniPaketi.DBAraKatmani;

public class KitapPersonel implements IKitapPersonel{
    private int kitapID, personelID;
    
    public KitapPersonel(){
        
    }
    
    
    public KitapPersonel(int kitapID, int personelID) { // Değişkenlere ilk değer ataması işlemi için yapıcı metot kullanımı.
        this.kitapID = kitapID;
        this.personelID = personelID;
    }
    
    
    public class OduncAlanPersonel{ // Dahili sınıf (Inner Classes) kullanımı.
        String personelBilgileri;
        Connection connection;
        
        public OduncAlanPersonel(){
            DBAraKatmani dBAraKatmani = new DBAraKatmani();
            connection = dBAraKatmani.baglan();
        }
        public String getPersonelBilgileri(){
            try {
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT adi,soyadi FROM tbl_personel WHERE personel_id='"+personelID+"'");
                
                while(resultSet.next()){
                    personelBilgileri = resultSet.getString("adi") + " " + resultSet.getString("soyadi") + ", ";
                }
                return personelBilgileri;
            } catch (Exception e) {
                System.out.println(e);
            }
            
            return null;
        }
    }
    
    
    @Override
    public void ekleme() {  // ekleme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO tbl_odunc (kitap_id, personel_id) VALUES ('"+kitapID+"', '"+personelID+"')");
             
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
            ResultSet resultSet = stmt.executeQuery("select * from tbl_odunc");
            
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    
    @Override
    public ResultSet ara() {  // arama
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from tbl_odunc where personel_id='"+personelID+"'");
 
            return resultSet;
            
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    
    @Override
    public void guncelle() {  // güncelleme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE tbl_odunc SET kitap_id='"+kitapID+"',personel_id='"+personelID+"'");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }

    
    @Override
    public void silme() {  // silme
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
        
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE from tbl_odunc WHERE kitap_id='"+kitapID+"' and personel_id='"+personelID+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
        dBAraKatmani.baglantiKes();
    }

    
    @Override
    public String personelOduncAldi() {  // JOptionPane için bilgi mesajı.
        OduncAlanPersonel personel = new OduncAlanPersonel();
        String personelBilgileri = personel.getPersonelBilgileri();
        
        DBAraKatmani dBAraKatmani = new DBAraKatmani();
        Connection connection = dBAraKatmani.baglan();
       
        
            try {
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT ismi FROM tbl_kitap WHERE kitap_id='"+kitapID+"'");
                
                while(resultSet.next()){
                    personelBilgileri += resultSet.getString("ismi") + " kitabını ödünç aldı.";
                }
                
                return personelBilgileri;
            } catch (Exception e) {
                System.out.println(e);
            }

        return null;
    }  
}
