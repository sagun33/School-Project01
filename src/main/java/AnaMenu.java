


import java.util.Scanner;

public class AnaMenu extends AnaMenuOverride {

    static Scanner input = new Scanner(System.in);
    static int tercih = 0;

    public static void giris() {
        Islemler islemler = new Islemler();
        AnaMenu mainMenu = new AnaMenu();
        System.out.println(
                "====================================\n" +
                        "\t ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ\n" +
                        "\t====================================\n" +
                        "\t 1- ÖĞRENCİ İŞLEMLERİ\n" +
                        "\t 2- ÖĞRETMEN İŞLEMLERİ\n" +
                        "\t 3- ŞİFRE DEĞİŞİKLİĞİ\n" +
                        "\t 4- ÇIKIŞ");

        System.out.print("Lutfen seciminizi yapiniz:");

        try {
            tercih = input.nextInt();
            switch (tercih) {
                case 1:
                    mainMenu.ogrenciIslemleri();
                    break;
                case 2:
                    mainMenu.ogretmenIslemleri();
                    break;
                case 3:
                    islemler.sifreDegistir();
                    break;
                case 4:
                    mainMenu.cikis();
                    break;
                default:
                    System.out.println("Lutfen gecerli secim yapiniz");

            }
        } catch (Exception e) {
            System.out.println("lutfen sayi giriniz");
            input.nextLine();
            giris();
        }


    }

    @Override
    public void ogrenciIslemleri() {
        Islemler.IslemlerMenu(1);


    }

    @Override
    public void ogretmenIslemleri() {
        Islemler.IslemlerMenu(2);
    }

    @Override
    public void cikis() {
        System.out.println("Sistemden cikis yaptiniz");
    }
}

