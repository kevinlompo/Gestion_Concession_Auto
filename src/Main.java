import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        List<Vehicule> vehicules = new ArrayList<>();

        // Moteur
        for (int i = 0; i<3; i++){
            ajout(vehicules);

            voiturePlusChere(vehicules);

            voiturePlusPetitKilometrage(vehicules);

            int prixTotal = prixTotal(vehicules);
            System.out.println("Le prix total est : " + prixTotal + "\n");
        }
    }

    // Ajout d'un véhicule à la concession
    private static void ajout(List<Vehicule> vehicules) {
        System.out.print("Entrer la marque de la voiture (que des lettres) : ");
        String marque = saisieMarque();
        System.out.print("Entrer le kilométrage de la voiture (que des entiers) : ");
        int kilo = saisieKilometrage();
        System.out.print("Entrer le prix de la voiture (que des entiers) : ");
        int prix = saisiePrix();
        Vehicule v = new Vehicule(marque, kilo, prix);

        vehicules.add(v);
        System.out.println(v);
    }

    // Saisie de la Marque du véhicule
    private static String saisieMarque() {
        Scanner sc = new Scanner(in);
        String saisi = "";
        try {
            saisi = sc.next();
            if (!saisi.matches("[a-zA-Z]+")) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.print(Constantes.lettreSeulement);
            saisieMarque();
        }
        return saisi;
    }

    // Saisie du Kilometrage du véhicule
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

    // Saisie du Prix du véhicule
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

    // 1- non gestion du cas pour lequel on a deux voitures qui ont le même prix
    // 2- pas d'utilisation des streams ? quelle version de java connais-tu ?
    private static void voiturePlusChere(List<Vehicule> vehicules) {
        OptionalInt prixMax = vehicules.stream().mapToInt(Vehicule::getPrix).max();

        System.out.println("\nLa voiture la plus chère est :");

        prixMax.ifPresentOrElse(maxPrice->
                        vehicules.stream().filter(vehicule -> vehicule.getPrix() == maxPrice)
                                .forEach(System.out::println),
                ()-> System.out.println(Constantes.aucuneDonnee));
    }

    // 1- non gestion du cas pour lequel on a deux voitures qui ont le même km
    // 2- pas d'utilisation des streams
    private static void voiturePlusPetitKilometrage(List<Vehicule> vehicules) {
        OptionalInt kmMin = vehicules.stream().mapToInt(Vehicule::getKilometrage).min();

        kmMin.ifPresentOrElse(min-> {
                    System.out.println("La voiture ayant le plus petit kilometrage est " + min + " pour la voiture : ");
                    vehicules.stream().filter(vehicule -> vehicule.getKilometrage() == min)
                            .forEach(System.out::println);
                },
                ()-> System.out.println(Constantes.aucuneDonnee));
    }

    // 1- pas d'utilisation des streams
    private static int prixTotal(List<Vehicule> vehicules) {

        if(vehicules.isEmpty()) {
            System.out.println(Constantes.aucuneDonnee);
        }

        return vehicules.stream().mapToInt(Vehicule::getPrix).sum();
    }

}