package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class YahtzeeSpel {
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private ArrayList<Dobbelsteen> dice = new ArrayList<Dobbelsteen>();
    private int[] blokkeerArray = {0, 0, 0, 0, 0};

    YahtzeeSpel() {
        for(int i = 0; i < 5; i++) {
            dice.add(new Dobbelsteen());
        }
    }

    void spelen() {
        for(Dobbelsteen element : dice) {
            element.waarde = rand.nextInt(6) + 1;
        }
        System.out.print("Je hebt ");
        for(int i = 0; i < 5; i++) {
            if (i == 4) {
                System.out.printf(" %3s %1d %9s", "en ", dice.get(i).waarde, "geworpen!");
                System.out.println();
            } else {
                System.out.printf(" %1d, ", dice.get(i).waarde);
            }
        }
    }

//    void vastHouden(){
//        //while (((input = scanner2.readLine()) != null) && (input.length()!= 0)) {
//        System.out.println("Wil je bepaalde dobbelstenen vasthouden? Typ, per dobbelsteen, 0 of 1. 0 betekent dat je hem niet vast wil houden.");
//        int i = 0;
//        while( i < 5){
//                blokkeerArray[i] = scanner.nextInt();
//                i++;
//            }
//        System.out.println("Jouw antwoord was: ");
//        }
//
//        void vastHouden2() {
//        System.out.println("Wil je bepaalde dobbelstenen vasthouden? Typ, per dobbelsteen, 0 of 1. 0 betekent dat je hem niet vast wil houden.");
//        Scanner scanner2 = new Scanner(System.in);
//        while (scanner2.hasNext()){
//            if (scanner2.hasNextInt())
//                System.out.println(scanner2.nextInt());
//            else
//                scanner2.next();
//        }
//    }

    void vastHouden() {
        System.out.println("Wil je bepaalde dobbelstenen vasthouden? Typ het nummer/de nummers van de dobbelsteen/dobbelstenen die je wil houden. \nDruk daarna op enter");
        System.out.println("Dit is wat je gegooid hebt: ");
        int i = 1;
        for (Dobbelsteen element : dice) {
            System.out.println("Dobbelsteen " + i + " = " + element.waarde);
            i++;
        }

        String[] inputArray = scanner.nextLine().split("\\s+", 5);
        if (inputArray[0].equals("")) {
            System.out.println("Ok, we bewaren niets");
        } else {
            for (String element : inputArray) {
                int charInt = parseInt(element);
                blokkeerArray[(charInt - 1)] = 1;
                System.out.println(Arrays.toString(blokkeerArray));
            }

        }

    }



    }

