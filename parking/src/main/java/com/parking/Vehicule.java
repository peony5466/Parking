package com.parking;

public class Vehicule {
   private String immatriculation; 


public Vehicule(String immatriculation) {
    this.immatriculation = immatriculation;
    
}


   public void changeImatriculation(String immatriculation){
    this.immatriculation = immatriculation;

   }
   //getter pour immatriculation
   public String getImmatriculation(){

    return immatriculation;
   }
    
   
}
