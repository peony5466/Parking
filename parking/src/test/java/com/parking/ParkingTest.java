package com.parking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ParkingTest {

    @Test
    // contexte_methodeSousTest_resultat
    public void VehiculesAutorisesVide_ajouterVehiculesAutorises_devraitAjouterLeVehicule() {
        // AAA : arrange(arranger/preparer), act(agir on appele la methode que l'on va
        // tester), assert(lansser la verififcation du test).

        // Arrange : je mets en place mon test, notamaent en instancient et initialisant
        // le ou les objets concérnes.
        Parking parking = new Parking(0);
        // Act ; j'appelle la methode qui est sous test.
        parking.ajouterVehiculesAutorises("ABC-123");
        // Assert: je verifié que tout s'est passé comme prévu (assert est un if).
        assertEquals(1, parking.getTailleVehiculesAutorises(), "Je devrais avoir exactement un véhicule autorisé");
        assertEquals("ABC-123", parking.getVehiculesAutorises().get(0), "l'immatriculation n'est pas correct");
        // le message s' affiche si on a proble
    }

    @Test
    public void VehiculeAutoriseDansLaListe_ajouterLeMemeVehiculeAutorise_devraitNePasEtreAjouter() {
        // arrange
        Parking parking = new Parking(0);
        parking.ajouterVehiculesAutorises("ABC-123");
        // act
        parking.ajouterVehiculesAutorises("ABC-123");
        // on essaye de verifier si on peut doubler l'immatriculation
        // assert
        assertEquals(1, parking.getTailleVehiculesAutorises(), "Doublons ajoutés et c'est faux code a revoir");

    }

    @Test
    public void VehiculeAutorise_enregistrementEntrerVehicule_devraitRentrer() {
        // arrange
        Parking parking = new Parking(1);
        parking.ajouterVehiculesAutorises("ABC-123");
        // act
        boolean res = parking.enregistrerEntrerVehicules("ABC-123");

        // assert
        assertEquals(true, res, "vehicule autorisé mais n'arrive pas à rentrer pas normal");

    }

    @Test
    public void VehiculeNonAutorise_enregistrementEntrerVehicule_devraitPasRentrer() {
        // arrange
        Parking parking = new Parking(1);
        // act
        boolean res = parking.enregistrerEntrerVehicules("ABC-123");

        // assert
        assertEquals(false, res, "vehicule autorisé mais n'arrive pas à rentrer pas normal");
    }

    @Test

    // methode(VehiculeAutoriseMaisParkingPlein) si enregistrementEntrerVehicule
    // donc devraitPasRentrer

    public void VehiculeAutoriseMaisParkingPlein_enregistrementEntrerVehicule_devraitPasRentrer() {
        // arrange
        Parking parking = new Parking(1);
        parking.ajouterVehiculesAutorises("ABC-123");
        parking.ajouterVehiculesAutorises("EFG-456");
        parking.enregistrerEntrerVehicules("ABC-123");
        // act

        boolean res = parking.enregistrerEntrerVehicules("EFG-456");

        // assert
        assertEquals(false, res, "parking plein");
    }

    @Test
    public void VehiculeAutorise_enregistrementSortirVehicule_devraitSortir() {
        // arrange
        Parking parking = new Parking(1);
        parking.ajouterVehiculesAutorises("ABC-123");
        parking.enregistrerEntrerVehicules("ABC-123");
        // act
        boolean res = parking.enregistrerSortieVehicule("ABC-123");

        // assert
        assertEquals(true, res, "vehicule autorisé mais n'arrive pas à rentrer pas normal");
    }

    @Test
    public void VehiculeAutorise_enregistrerEntrerVehicule_devraitexister() {
        // arrange
        Parking parking = new Parking(0);
        parking.ajouterVehiculesAutorises("ABC-123");
        // act
        parking.enregistrerEntrerVehicules("ABC-123");

        // assert
        assertEquals(0, parking.getTailleVehiculesStationes(),
                "vehicule existe");
    }

    @Test
    public void NbVehiculeStationes_enregistrerEntrerVehicules_devraitmedonnerlenbdevehiculesstationes() {
        // arrange
        Parking parking = new Parking(0);
        parking.ajouterVehiculesAutorises("LMN-000");
        // act
        parking.enregistrerEntrerVehicules("LMN-000");

        // assert
        assertEquals(0, parking.getTailleVehiculesStationes(),
                "le nombre vehicules stationes");
    }

    @Test
    public void VehiculeAutorise_enregistrementEntrerVehicule_devraitPasRentrer() {
        // arrange
        Parking parking = new Parking(1);
        parking.ajouterVehiculesAutorises("ABC-123");// ajouter abc-123 et l'enregistrer dans la liste
        parking.enregistrerEntrerVehicules("ABC-123");
        parking.ajouterVehiculesAutorises("DEF-456");// ajouter def456 sans l'enregistrer
        parking.ajouterVehiculesAutorises("DEF-456");
        // act
        parking.enregistrerEntrerVehicules("DEF-456");
        // assert
        assertEquals(1, parking.getTailleVehiculesStationes(),
                "pouvoir rentrer");
    }

    @Test
    public void VehiculeAutorise_ajouterVehiculesAutorises_parkingPlein() {
        // arrange
        Parking parking = new Parking(1);
        parking.ajouterVehiculesAutorises("DEF-456");
        // act
        parking.ajouterVehiculesAutorises("DEF-456");
        // assert
        assertEquals(0, parking.getTailleVehiculesStationes(),
                "");
    }

    @Test
    public void VehiculeAutorise_ajouterVehiculesAutorises_nbVehiculesStationes() {
        // arrange
        Parking parking = new Parking(1);
        parking.ajouterVehiculesAutorises("DEF-456");
        // act
        parking.ajouterVehiculesAutorises("DEF-456");
        // assert
        assertEquals(0, parking.getNbVehiculesStationes(),
                "");
    }

    @Test
    public void unVehiculeAutorises_listeVehiculesAutorises_listeDeVehicule() {

        Parking parking = new Parking(0);
        parking.ajouterVehiculesAutorises("ABC-234");
        assertEquals(0, parking.getTailleVehiculesStationes(),
                "");

    }

    @Test
    public void VehiculeStationneCapaciteMaximale_tauxDeRemplissage() {
        Parking parking = new Parking(2);
        parking.ajouterVehiculesAutorises("ABC-234");
        parking.enregistrerEntrerVehicules("ABC-234");
        assertEquals(50, parking.tauxRemplissage(),
                "Taux de repmlissage");
    }
}
