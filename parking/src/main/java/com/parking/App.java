package com.parking;

public class App {

  public static void main(String[] args) {
    Vehicule voiture1 = new Vehicule("ABC-123");
    voiture1.changeImatriculation("A2-hiba");
    System.out.println(voiture1.getImmatriculation());

    Parking parking = new Parking(500);
    parking.ajouterVehiculesAutorises("DCE-123");
    parking.enregistrerEntrerVehicules("DCE-123");
    parking.enregistrerSortieVehicule("DCE-123");
    parking.estStationnes("DCE-123");
    parking.estPlein();
    parking.getNbVehiculesStationes();

  }

}
