


import java.util.Scanner;

public class Islemler implements IslemlerInterface {
    static Scanner input = new Scanner(System.in);
    static int tercih = 0;
    static int secim2 = 0;

    public static void IslemlerMenu(int i) {

        Islemler islemler = new Islemler();
        tercih = i;
        System.out.println("============= İŞLEMLER =============\n" +
                "\t\t 1-EKLEME\n" +
                "\t\t 2-ARAMA\n" +
                "\t\t 3-LİSTELEME\n" +
                "\t\t 4-SİLME\n" +
                "\t\t 5-ANA MENÜ\n" +
                "\t\t 6-ÇIKIŞ\n");

        System.out.println("Lutfen Secim yapiniz");
        try {

            secim2 = input.nextInt();
            switch (secim2) {
                case 1:
                    islemler.ekleme();
                    IslemlerMenu(tercih);
                    break;
                case 2:
                    islemler.arama();
                    IslemlerMenu(tercih);
                    break;
                case 3:
                    islemler.listeleme();
                    IslemlerMenu(tercih);
                    break;
                case 4:
                    islemler.silme();
                    IslemlerMenu(tercih);
                    break;
                case 5:
                    islemler.anaMenu();
                    break;
                case 6:
                    islemler.cikis();
                    break;
                default:
                    System.out.println("hatali giris");
                    IslemlerMenu(i);
            }
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Lutfen gecerli secim yapiniz");
            IslemlerMenu(i);
        }

    }

    @Override
    public void ekleme() {

        System.out.println("Kimlik numarasi giriniz:");
        String kimlikID = input.next();
        kimlikIDKontrol(kimlikID);
        if (tercih == 1) {
            ogrenciBilgiAlKaydet(kimlikID);
        } else {
            ogretmenBilgiAlKaydet(kimlikID);
        }
    }

    private void ogretmenBilgiAlKaydet(String kimlikID) {

        System.out.println("Ad Soyad giriniz");
        input.nextLine();
        String adSoyad = input.nextLine();
        System.out.println("yasinizi giriniz");
        String yas = input.next();
        input.nextLine();
        System.out.println("Bolum no giriniz");
        String bolumNo = input.next();
        System.out.println("Sicil no giriniz");
        String sicilNo = input.next();
        Ogretmen teacher = new Ogretmen(adSoyad, yas, bolumNo, sicilNo);
        Ogretmen.ogretmenListesiMap.put(kimlikID, teacher);
    }

    private void ogrenciBilgiAlKaydet(String kimlikID) {

        System.out.println("Ad Soyad giriniz");
        input.nextLine();
        String adSoyad = input.nextLine();
        System.out.println("yasinizi giriniz");
        String yas = input.next();
        input.nextLine();
        System.out.println("Numara giriniz");
        String numara = input.next();
        System.out.println("Sinifi giriniz");
        String sinif = input.next();
        Ogrenci students = new Ogrenci(adSoyad, yas, numara, sinif);
        Ogrenci.ogrenciListesiMap.put(kimlikID, students);
    }

    private void kimlikIDKontrol(String kimlikID) {

        if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID) || Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
            System.out.println("Bu ID kayit yapilmis ");
            AnaMenu.giris();
        }
    }

    @Override
    public void arama() {

        System.out.println("Kimlik numarasi girin");
        String kimlikID = input.next();
        if (tercih == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogrenci.ogrenciListesiMap.get(kimlikID));
            } else {
                System.out.println("kayitli degil");
            }
        } else if (tercih == 2) {
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogretmen.ogretmenListesiMap.get(kimlikID));
            } else {
                System.out.println("kayitli degil");
            }
        }
    }

    @Override
    public void listeleme() {

        if (tercih == 1) {
            System.out.println(Ogrenci.ogrenciListesiMap);
        } else if (tercih == 2) {
            System.out.println(Ogretmen.ogretmenListesiMap);
        }
    }

    @Override
    public void silme() {

        System.out.println("Kimlik numarasi girin");
        String kimlikID = input.next();
        if (tercih == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                Ogrenci.ogrenciListesiMap.remove(kimlikID);
            } else {
                System.out.println("kimlik ID mevcut degil");
            }
        } else if (tercih == 2) {
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                Ogretmen.ogretmenListesiMap.remove(kimlikID);
            } else {
                System.out.println("kimlik ID mevcut degil");
            }
        }
    }

    @Override
    public void anaMenu() {

        AnaMenu.giris();
    }

    @Override
    public void sifreDegistir() {
        System.out.println("Lutfen kullanici adinizi gırınız");
        String girilenKullaniciAdi = input.nextLine();
        System.out.println("Lutfen guncel parolanizi giriniz");
        String guncelParola = input.nextLine();
        if (girilenKullaniciAdi.equals(KullaniciGirisi.userName) && guncelParola.equals(KullaniciGirisi.parola)) {
            System.out.println("Lutfen yeni sifrenizi giriniz");
            KullaniciGirisi.parola = input.nextLine();
            System.out.println("Parolaniz " + KullaniciGirisi.parola + " olarak guncellenmistir");
            AnaMenu.giris();
        } else {
            System.out.println("Kullanici adi ve parola hatali");
        }
    }

    @Override
    public void cikis() {

        System.out.println("Sistemden cikis yaptiniz");
    }
}

