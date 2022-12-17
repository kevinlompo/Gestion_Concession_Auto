import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        List<Vehicule> vehicules = new ArrayList<>();

   /*     vehicules.add(new Vehicule("B", 100, 150));
        vehicules.add(new Vehicule("X", 5, 10));
        vehicules.add(new Vehicule("DODO", 2, 1540));
        vehicules.add(new Vehicule("DODOMOBILE", 1234566, 145640));*/

        /*   */

        for (int i = 0; i<3; i++){
            ajout(vehicules);
            Vehicule voitureChre = voiturePlusChere(vehicules);
            System.out.println("\nLa voiture la plus chère est " + voitureChre.getMarque());

            Vehicule voiturePetitK = voiturePlusPetitKilometrage(vehicules);

            System.out.println("La voiture ayant le plus petit kilometrage est " + voiturePetitK.getKilometrage() + " pour la voiture : " + voiturePetitK.getMarque());

            int prixTotal = prixTotal(vehicules);
            System.out.println("Le prix total est : " + prixTotal + "\n");
        }

    }

    private static void ajout(List<Vehicule> vehicules) {
        System.out.print("Entrer la marque de la voiture(que des lettres) : ");
        String marque = saisieMarque();
        System.out.print("Entrer le kilométrage de la voiture(que des entiers) : ");
        int kilo = saisieKilometrage();
        System.out.print("Entrer le prix de la voiture(que des entiers) : ");
        int prix = saisiePrix();
        Vehicule v = new Vehicule(marque, kilo, prix);

        vehicules.add(v);
        System.out.println(v.toString());
    }

    private static String saisieMarque() {
        Scanner sc = new Scanner(in);
        String saisi = "";
        try {
            saisi = sc.next();
            if (!saisi.matches("[a-zA-Z]+")) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.print(Constantes.entierSeulement);
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
            System.out.print(Constantes.entierSeulement);
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
            System.out.print(Constantes.entierSeulement);
            saisiePrix();
        }
        return saisi;
    }

    private static Vehicule voiturePlusChere(List<Vehicule> vehicules) {
        Vehicule v = new Vehicule("",0,0);
        int val = Integer.MIN_VALUE;
        List<Integer> test = new ArrayList();
        if (vehicules.size() > 1) {
            for (int i = 0; i < vehicules.size(); i++) {
                test.add(vehicules.get(i).getPrix());
                if (test.get(i) > val) val = test.get(i);

            }

            for (int i = 0; i < test.size(); i++) {
                if (vehicules.get(i).getPrix() == val) {
                    v = vehicules.get(i);
                }

            }

        } else if (vehicules.size() == 1) {
            v = vehicules.get(0);
        }
        else {
            System.out.println(Constantes.aucuneDonnee);
        }
        return v;
    }

    private static Vehicule voiturePlusPetitKilometrage(List<Vehicule> vehicules) {
        Vehicule v = new Vehicule("",0,0);
        int val = Integer.MAX_VALUE;
        List<Integer> test = new ArrayList();
        if (vehicules.size() > 1) {
            for (int i = 0; i < vehicules.size(); i++) {
                test.add(vehicules.get(i).getKilometrage());
                if (test.get(i) < val) val = test.get(i);

            }

            for (int i = 0; i < test.size(); i++) {
                if (vehicules.get(i).getKilometrage() == val) {
                    v = vehicules.get(i);
                }

            }

        } else if (vehicules.size() == 1) {
            v = vehicules.get(0);
        }
        else {
            System.out.println(Constantes.aucuneDonnee);
        }

        return v;
    }

    private static int prixTotal(List<Vehicule> vehicules) {
        int total = 0;
        for (Vehicule v :
                vehicules) {
            total += v.getPrix();
        }
        return total;
    }

    @Override
    public String toString() {
        String info = "Les informations du véhicule sont : ";
        info += super.toString();
        return info;
    }
}