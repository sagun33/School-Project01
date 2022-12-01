
import java.util.HashMap;
import java.util.Map;

public class Ogrenci extends Kisi {

    static Map<String,Ogrenci> ogrenciListesiMap=new HashMap<>();

    private String numara = "";
    private String sinif = "";

    public Ogrenci() {
    }

    public Ogrenci(String adSoyad, String dogumTarihi, String numara, String sinif) {
        super(adSoyad, dogumTarihi);
        this.numara = numara;
        this.sinif = sinif;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    @Override
    public String toString() {
        return " Ogrenci ==> " +
                "numara = \"" + numara + '\"' +
                ", sinif = \"" + sinif + '\"' +
                " **** " + super.toString();
    }
}

