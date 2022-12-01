


import java.util.Scanner;

public class KullaniciGirisi implements KullaniciGirisiInterface{
    static Scanner input = new Scanner(System.in);
    static final String userName = "hanzel";
    static String parola="12345";
    @Override
    public void kullaniciGirisi() {
        String kullaniciAdi="";
        String kullaniciParola="";

        System.out.println("===================OKUL YONETIMINE HOSGELDINIZ==================");

        System.out.println("Lutfen kullanici adinizi giriniz");
        kullaniciAdi= input.nextLine();

        System.out.println("Lutfen parolanizi giriniz");
        kullaniciParola= input.nextLine();

        if ((kullaniciAdi.equals(userName) && kullaniciParola.equals(parola))){
            AnaMenu.giris();
        }else{
            System.out.println("Kullanici adi ve  parolaniz yanlis tekrar deneyiniz");
            kullaniciGirisi();
        }
    }
}

