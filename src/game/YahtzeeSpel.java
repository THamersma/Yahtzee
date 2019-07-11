package game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class YahtzeeSpel {
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private ArrayList<Dobbelsteen> dice = new ArrayList<Dobbelsteen>();
    int[] blokkeerArray = {0, 0, 0, 0, 0};
    Worp worp = new Worp();

    YahtzeeSpel() {
        for (int i = 0; i < 5; i++) {
            dice.add(new Dobbelsteen());
        }
    }

    void spelen(ArrayList<Speler> spelerLijst) {

        while (true) {
            int dobbelsteenBlock = 0;
            //eeste manier die ik bedacht. Mooier dan een for loopje, maar, zover als ik weet, kan ik dan de index niet bepalen
//            for(Dobbelsteen element : dice) {
//                element.waarde = rand.nextInt(6) + 1;
//            }
            for(Speler speler:  spelerLijst ){
                System.out.println(speler.naam + " het is jouw beurt!");
                for (int i = 0; i < 5; i++) {
                    if (speler.spelerBlocks.size() != 0) {
                        dobbelsteenBlock = speler.spelerBlocks.get(speler.spelerBlocks.size() -1)[i];
                    }
                    if (dobbelsteenBlock == 0) {
                        dice.get(i).waarde = rand.nextInt(6) + 1;
                        worp.worpen[i] = dice.get(i).waarde;
                    } else {
                        worp.worpen[i] = speler.spelerWorpen.get(speler.spelerWorpen.size()-1)[i];
                    }
                }
                speler.spelerWorpen.add(Arrays.copyOf(worp.worpen, 5));
                if (speler.spelerWorpen.size() == 3 && speler.naam.equals("Speler2")) {
                        if (spelerLijst.get(0).totalSum > spelerLijst.get(1).totalSum) {
                            System.out.println("Speler1 wint!");
                        } else {
                            System.out.println("Speler2 wint");
                        }
                        System.out.println("Het einde is bereikt");
                        break;
                } else {
                    vastHouden(speler);
                }
            }
        }
    }

    void reviewScore(Speler speler){
        System.out.println("Dit is wat je gegooid hebt: ");
        int[] spelerX = speler.spelerWorpen.get(speler.spelerWorpen.size()-1);
        for(int i = 0 ; i < 5; i++) {
            System.out.println("Dobbelsteen " + (i+1) + ": " + spelerX[i]);
        }
        speler.totalSum = returnSum(spelerX);
        System.out.println("Uw totaal is: " + speler.totalSum);
    }

    int returnSum(int[] spelerX){
        int sum = 0;
        for(int i =0; i < 5; i++){
            sum += spelerX[i];
        }
        return sum;
    }



    void vastHouden(Speler speler) {
        reviewScore(speler);
        System.out.println("Wil je bepaalde dobbelstenen vasthouden? Typ het nummer/de nummers van de dobbelsteen/dobbelstenen die je wil houden. Druk daarna op enter");
        while (true) {
            String input = scanner.nextLine();
            if (input.length() > 10) {
                System.out.println("Voer aub maximaal 5 cijfers in.");
                continue;
            } else if (!input.contains(" ") && input.length() > 1) {
                System.out.println("Voer aub spaties in tussen de cijfers.");
                continue;
            } else {
                String[] inputArray = input.split("\\s+", 5);
                if (inputArray[0].equals("") && inputArray.length == 1) {
                    System.out.println("Ok, we bewaren niets");
                    return;
                } else {
                    for (String element : inputArray) {
                        if (element.equals("")) {
                            continue;
                        } else {
                            int charInt = parseInt(element);
                            blokkeerArray[(charInt - 1)] = 1;
                        }
                    }
                    speler.spelerBlocks.add(Arrays.copyOf(blokkeerArray, 5));
                    System.out.println("Top, doen we! OK, door naar het volgende rondje!");
                    Main.enterToContinue();
                    break;
                }
            }
        }
    }
}

