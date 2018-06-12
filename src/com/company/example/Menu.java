package com.company.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this );


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
                    input.nextLine();
                    //Add game
                    System.out.println("you have chosen to add a game");

                    library.addGame();
                    break;
                case 2:
                    input.nextLine();
                    //Remove game
                    library.listGamesInLibrary("inLibrary");
                    library.removeGame(input.nextInt() - 1);
                    break;
                case 3:
                    input.nextLine();
                    //View current library
                    library.listGamesInLibrary("inLibrary");
                    library.removeGame(input. nextInt() -1);
                    break;
                case 4:
                    input.nextLine();
                    //check out game
                    System.out.println("You have chose to check out a game" +
                    "\nHere is a list of all games available to check out:");
                    library.listGamesInLibrary("checkout");
                    System.out.println("choose a number for the game you would like: ");
                    library.checkOutGames(input.nextInt() - 1);
                    break;
                case 5:
                    //check in a game
                    break;
                case 6:
                    //View checked out games
                    break;
                case 7:
                    //Exit program
                    System.exit(0);
                    break;
                default:
                    //Prompt user to pick a correct number, loop back to menu.
                    System.out.println("Please choose a number between 1 and 7.");
                    startMenu();
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();
                    System.out.println("that is not a valid entry. please enter a number between 1 and 7.");
            startMenu();
        }

    }
}
