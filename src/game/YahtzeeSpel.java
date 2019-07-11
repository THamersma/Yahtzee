package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class YahtzeeSpel {
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private ArrayList<Dobbelsteen> dice = new ArrayList<Dobbelsteen>();
    private int[] blokkeerArray = {0, 0, 0, 0, 0};

    YahtzeeSpel() {
        for (int i = 0; i < 5; i++) {
            dice.add(new Dobbelsteen());
        }
    }

    void spelen() {
        int aantalWorpen = 0;
        while (true) {
            //eeste manier die ik bedacht. Mooier dan een for loopje, maar, zover als ik weet, kan ik dan de index niet bepalen
//            for(Dobbelsteen element : dice) {
//                element.waarde = rand.nextInt(6) + 1;
//            }
            for (int i = 0; i < 5; i++) {
                int dobbelsteenBlock = blokkeerArray[i];
                if (dobbelsteenBlock == 0) {
                    dice.get(i).waarde = rand.nextInt(6) + 1;
                }
            }
            aantalWorpen++;
            if (aantalWorpen == 3) {
                reviewScore();
                //naar eindstand functie?
                // laat de score nog zien en geef de eindscore
                System.out.println("Het einde is bereikt");
                break;
            } else {
                vastHouden();
            }
        }
    }

    void reviewScore(){
        System.out.println("Dit is wat je gegooid hebt: ");
        int i = 1;
        for (Dobbelsteen element : dice) {
            System.out.println("Dobbelsteen " + i + " = " + element.waarde);
            i++;
        }
    }

    void vastHouden() {
//        System.out.println("Wil je bepaalde dobbelstenen vasthouden? Typ het nummer/de nummers van de dobbelsteen/dobbelstenen die je wil houden. Druk daarna op enter");
//        System.out.println("Dit is wat je gegooid hebt: ");
//        int i = 1;
//        for (Dobbelsteen element : dice) {
//            System.out.println("Dobbelsteen " + i + " = " + element.waarde);
//            i++;
//        }
        reviewScore();
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
                } else {
                    for (String element : inputArray) {
                        if (element.equals("")) {
                            continue;
                        } else {
                            int charInt = parseInt(element);
                            blokkeerArray[(charInt - 1)] = 1;
                            //System.out.println(Arrays.toString(blokkeerArray));
                        }
                    }
                    System.out.println("Top, doen we! OK, door naar het volgende rondje!");
                    Main.enterToContinue();
                    break;
                }
            }
        }
    }
}

