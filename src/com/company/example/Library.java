package com.company.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Library {

    private Scanner input = new Scanner(System.in);
    private List<Game> gamesLibrary = new ArrayList<Game>();
    private List<Game> checkOutGames = new ArrayList<Game>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    private Menu menu;


    public Library(Menu menu) {
        this.menu = menu;
    }

    public void addGame() {

        System.out.println("What is the title of your game?");
        String title = input.nextLine();
        System.out.println("What type of game is this?");
        String type = input.nextLine();
        System.out.println("What is the ID number of this game?");
        int idNumber = input.nextInt();

        Game game = new Game(title, type, idNumber);
        gamesLibrary.add(game);
        System.out.println("You have added " + game.getTitle() + " to your library, this game can now be checked out. \n");

        menu.startMenu();

    }

//    public void removeGame() {
//
//        System.out.println("What is the title of your game?");
//        String title = input.nextLine();
//        System.out.println("What type of game is this");

    // }

    public void removeGame(int index) {

        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library");
        } else {

            gamesLibrary.remove(index);
            System.out.println("This game has been removed from your library.");

        }
        menu.startMenu();
    }

        public void listGamesInLibrary (String location){

            if (gamesLibrary.isEmpty()) {
                System.out.println("There are no games in your library. Add a game from the Main Menu.");
            } else {
                int index = 1;
                for (Game inLibrary : gamesLibrary) {
                    System.out.println(index++ + ": " + inLibrary.getTitle());
                }
            }
            if (location.equals("inLibrary")) {
                menu.startMenu();
            }
        }
        public void checkOutGames(int index) {
        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library, add some games to be able to check out.");
        } else {
            Game game = gamesLibrary.get(index);

            //Create an instance of the calender object
            Calendar calendar = Calendar.getInstance();
            
            //Add 7 days to the current date
            calendar.add(Calendar.DAY_OF_YEAR, 7);

            //Uses the line above to set a due date in the future to a variable
            String dueDate = dateFormat.format(calendar.getTime());

            //tell user what their due date is
            System.out.println( game.getTitle() + " is due on " + dueDate);

            //Set dueDate for this game
            game.setDueDate(dueDate);

        }
        }
    }

