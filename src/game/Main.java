package game;

import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        int worp;

        YahtzeeSpel spel = new YahtzeeSpel();
        ArrayList<Speler> spelerLijst = new ArrayList<>();
        spelerLijst.add(new Speler("Speler1"));
        spelerLijst.add(new Speler("Speler2"));
        System.out.println("Hallo en welkom bij Yahtzee! \nHet is iets anders dan de klassieke Yahtzee. Het gaat hier niet om bepaalde sets, maar gewoon de hoogste score. \nLekker makkelijk dus. Nu gaan we gelijk maar dobbelen!");
        enterToContinue();
        spel.spelen(spelerLijst);
        //spel.vastHouden();

    }

    static void enterToContinue() {
        System.out.println("##### Druk op enter om door te gaan.");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


