package com.company.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    //Menu to prompt user for Library options
    public void startMenu () {

        System.out.println("What would you like to do?" +
        "\n1. Add a game to the library" +
        "\n2. Remove a game from the library" +
        "\n3. View what is currently in the library" +
        "\n4. check out a game" +
        "\n5. check in a game" +
        "\n6. View check out games" +
        "\n7. Exit the program");

        try {
            switch (input.nextInt()) {

                case 1:
                    //Add game
                    break;
                case 2:
                    //Remove game
                    break;
                case 3:
                    //View current library
                case 4:
                    //check out game
                    break;
                case 5:
                    //check in a game
                    break;
                case 6:
                    //View checked out games
                    break;
                case 7:
                    //Exit program
                    break;
                default:
                    //Prompt user to pick a correct number, loop back to menu.
                    System.out.println("Please choose a number between 1 and 7.");
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();
                    System.out.println("that is not a valid entry. please enter a number between 1 and 7.");
            startMenu();
        }

    }
}
