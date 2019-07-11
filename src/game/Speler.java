package game;

import java.util.ArrayList;

public class Speler {
    ArrayList<int[]> spelerWorpen = new ArrayList<>();
    ArrayList<int[]> spelerBlocks = new ArrayList<>();
    int totalSum;

    //blokkeerarray per speler toevoegen na worp
    String naam;

    Speler(String naam) {
        this.naam = naam;
    }

}
