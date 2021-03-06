package com.company.example;

import java.text.ParseException;
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

    public void listGamesInLibrary(String location) {

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
            System.out.println(game.getTitle() + " is due on " + dueDate);

            //Set dueDate for this game
            game.setDueDate(dueDate);

            //Add game to checked out list
            checkOutGames.add(game);

            //Remove game from library
            gamesLibrary.remove(game);

        }
        menu.startMenu();
    }

    public void checkInGame(int index) {

        //Get game using index from checkedOutGames
        Game game = checkOutGames.get(index);
        gamesLibrary.add(game);

        try {
            Calendar calendar = Calendar.getInstance();
            if (dateFormat.parse(dateFormat.format(calendar.getTime())).before(dateFormat.parse(game.getDueDate()))) {
                System.out.println("Thinks for turning your game in on time!");
            } else {
                System.out.println("Shame on you! you were late turning in your game :( ");
            }


        } catch (ParseException pe) {
            //We will leave this empty since we don't really need to do anything if we
        }
    }


    public void listCheckedOut(String location) {
        //checks to see if our arrayList is empty
        if (checkOutGames.isEmpty()) {
            System.out.println("There are no games currently checked out.");
            menu.startMenu();
        } else {
            int index = 0;
            //iterate through checkedOutGames list
            for (Game game : checkOutGames) {
                //Increment index by 1 and print out that number followed by the game title

                System.out.println(++index + ": " + game.getTitle());
            }
        }
        if (location.equals("listCheckedOut")) {
            menu.startMenu();
        }

    }
}

