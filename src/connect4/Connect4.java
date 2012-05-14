/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.util.*;

public class Connect4 {

    public static void main(String[] args) {
        int state = 0;
        int max_players = 2; //could be set to n
        int player = 1; //player 1 allways starts
        Grid grid = new Grid(); //new instance of grid
        cliDisplay clidisplay = new cliDisplay(grid.get_xsize(), grid.get_ysize());//making a clidisplay 

        Scanner input = new Scanner(System.in); //used to hold user inputs

        while (state != -1) {//checks if program is in quitting stage
            switch (state) {
                case 0:
                    System.out.println("player " + player + "'s turn");
                    clidisplay.display(grid.get_matrix());//print out the grid
                    int x = 0;// xposition is set to 0 before taking user input
                    try {// tries to do get an int from the user
                        x = input.nextInt();
                        if (x <= 0 || x > grid.get_xsize()) {
                            throw new Exception();
                        }
                    } catch (Exception exc) {
                        System.out.println("not a number between 1 and "
                                + grid.get_xsize());
                        input.nextLine();
                    }
                    //checks if user input is within range
                    if (x > 0 && x < grid.get_xsize() + 1) {
                        x--;
                        int y = grid.find_y(x);//check for space in collumn
                        if (y != -1) {
                            //sets a place to current player
                            if (grid.set_and_check(x, y, player)) {
                                state = 1;
                            } else if (grid.draw_game()) {//checks for drawgame
                                state = 2;
                            } else {
                                //change player
                                player = grid.changeplayer(player, max_players);
                            }
                        } else {
                            System.out.println("collumn filled");
                        }
                    }
                    break;
                case 1://prints endgame with winner
                    clidisplay.display(grid.get_matrix());//print out the grid
                    System.out.println("\nwinner is player " + player
                            + "\nPlay again?\n"
                            + "press 0 for new game\n"
                            + "press anything else to quit");
                    int choice = -1;
                    try {//checks for user input == int == 0
                        choice = input.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Quitting");
                        state = -1;
                    }
                    if (choice == 0) {
                        state = 0;
                        grid = new Grid();
                        player = 1;
                    }
                    break;
                case 2://prints end game eith draw game
                    clidisplay.display(grid.get_matrix());//print out the grid
                    System.out.println(
                            "\ndraw game"
                            + "\nPlay again?\n"
                            + "press 0 for new game\n"
                            + "press anything else to quit");
                    choice = -1;
                    try {//checks for user input == int == 0
                        choice = input.nextInt();
                    } catch (Exception exc) {
                        System.out.println("Quitting");
                        state = -1;
                    }
                    if (choice == 0) {
                        state = 0;
                        grid = new Grid();
                        player = 1;
                    }
                    break;
            }
        }
    }
}
