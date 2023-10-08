package com.parking;

import java.util.ArrayList;

public class Parking {

    private int capaciteMaximale;
    private ArrayList<String> VehiculesAutorises;
    private ArrayList<String> VehiculesStationes;

    public Parking(int capacite) { // creer une variable capacite quand on donne une valeur a capacite comme 500 on
                                   // a plus capacite on a 500 donc capacitemaximale=capacite=>capacitemaximale=500

        capaciteMaximale = capacite;
        VehiculesAutorises = new ArrayList<>();
        VehiculesStationes = new ArrayList<>();

    };

    // la liste des vehicules autorises doit etre vide au debut
    public ArrayList<String> getVehiculesAutorises() {
        return VehiculesAutorises;
    };

    public int getTailleVehiculesAutorises() {
        return VehiculesAutorises.size();
    }

    // On doit pouvoir savoir si un véhicule donné est sur le parking ou pas.
    public int getTailleVehiculesStationes() {
        return VehiculesStationes.size();
    }

    public boolean ajouterVehiculesAutorises(String immatriculation) {
        // si le vehicule est autorisé j'ouvre sinon j'ouvre pas
        if (!this.VehiculesAutorises.contains(immatriculation)) {
            VehiculesAutorises.add(immatriculation);
            return true;
        }
        return false;
    }

    public boolean enregistrerEntrerVehicules(String immatriculation) {
        if (VehiculesAutorises.contains(immatriculation) && !estPlein()) {
            VehiculesStationes.add(immatriculation);
            return true;
        }
        return false;
    }

    public boolean enregistrerSortieVehicule(String immatriculation) {
        if (immatriculation.equals(immatriculation)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estStationnes(String immatriculation) {
        if (immatriculation.equals(immatriculation)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean estPlein() {
        if (VehiculesStationes.size() == capaciteMaximale) {
            return true;
        } else {
            return false;
        }

    }

    // le nombre de vehicule qui est actuellement sur le parking
    public int getNbVehiculesStationes() {
        return VehiculesStationes.size();
    }
    // On doit pouvoir afficher la liste des véhicules actuellement sur le parking.

    public ArrayList<String> getVehiculesStationes() {
        return VehiculesStationes;

    }

    // On doit pouvoir afficher la liste des véhicules autorisés.
    public ArrayList<String> getVehiculesAtorises() {
        return VehiculesAutorises;
    }

    public float tauxRemplissage() {
        float tauxRemplissage = (float) this.VehiculesStationes.size() / this.capaciteMaximale * 100;
        return tauxRemplissage;
    }
}
