package mainsource;
public class App {
    public static void main(String[] args) throws Exception {
        
        HelloWorld greet_1 = new HelloWorld();
        // greet_1.SayHi();

        HelloName greet_2 = new HelloName();
        greet_2.SelfIntro();

        Lingkaran lingkaran_1 = new Lingkaran();
        System.out.println(lingkaran_1.HitungKeliling());

        Segitiga segitiga_1 = new Segitiga();
        System.out.println(segitiga_1.hitungLuas());

        Tabung tabung_1 = new Tabung();
        System.out.println(tabung_1.HitungVolume());
    }
}
    