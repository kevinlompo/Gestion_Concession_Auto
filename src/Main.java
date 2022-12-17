import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        vehicules.add(new Vehicule("B", 100, 150));
      /*  vehicules.add(new Vehicule("C", 600, 200));
        vehicules.add(new Vehicule("X", 5, 250));*/

       Vehicule voitureChre = voiturePlusChere(vehicules);
        System.out.println("La voiture la plus chère est " + voitureChre.getMarque());

        Vehicule voiturePetitK = voiturePlusPetitKilometrage(vehicules);

        System.out.println("La voiture ayant le plus petit kilometrage est " + voiturePetitK.getKilometrage());

        int prixTotal = prixTotal(vehicules);
        System.out.println("Le prix total est : " + prixTotal);

        ajout(vehicules);
    }

    private static void ajout(List<Vehicule> vehicules){
        System.out.print("Entrer la marque de la voiture(que des lettres) : ");
        String marque = saisieMarque();
        System.out.print("Entrer le kilométrage de la voiture(que des entiers) : ");
        int kilo = saisieKilometrage();
        System.out.print("Entrer le prix de la voiture(que des entiers) : ");
        int prix = saisiePrix();

        vehicules.add(new Vehicule(marque,kilo,prix));
    }

    private static String saisieMarque() {
        Scanner sc = new Scanner(in);
        String saisi = "";
        try {
             saisi =  sc.next();
        } catch (Exception e) {
            System.out.print("Entrer que des lettres : ");
            saisieMarque();
        }
        return saisi;
    }

    private static int saisieKilometrage() {
        Scanner sc = new Scanner(in);
        int saisi = 0;
        try {
            saisi = sc.nextInt();
        } catch (Exception e) {
            System.out.print("Entrer que des entiers : ");
            saisieKilometrage();
        }
        return saisi;
    }

    private static int saisiePrix() {
        Scanner sc = new Scanner(in);
        int saisi = 0;
        try {
            saisi = sc.nextInt();
        } catch (Exception e) {
            System.out.print("Entrer que des entiers : ");
            saisiePrix();
        }
        return saisi;
    }
        private static Vehicule voiturePlusChere(List<Vehicule> vehicules) {
            Vehicule v = new Vehicule("", 2, 5);
        for (int i = 0; i<vehicules.size(); i++){
            if (vehicules.get(i).getPrix() < vehicules.get(++i).getPrix()){
                v = vehicules.get(++i);
            }
        }

        return v;
    }

    private static Vehicule voiturePlusPetitKilometrage(List<Vehicule> vehicules) {
        Vehicule v = new Vehicule("", 2, 5);
        for (int i = 0; i<vehicules.size(); i++){
            if (vehicules.get(i).getKilometrage() < vehicules.get(++i).getKilometrage()){
                v = vehicules.get(++i);
            }
        }
        return v;
    }

    private static int prixTotal(List<Vehicule> vehicules){
        int total = 0;
        for (Vehicule v:
             vehicules) {
            total += v.getPrix();
        }
        return total;
    }

}