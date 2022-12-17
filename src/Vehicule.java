import java.util.ArrayList;
import java.util.List;

public class Vehicule {
    String marque;
    int kilometrage;
    int prix;

    public Vehicule(String marque, int kilometrage, int prix){
        this.marque = marque;
        this.kilometrage = kilometrage;
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

}
