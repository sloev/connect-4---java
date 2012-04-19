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

        Scanner input = new Scanner(System.in); //used to hold user inputs

        while (state != -1) {//checks if program is in quitting stage
            switch (state) {
                case 0:
                    System.out.println("player " + player + "'s turn");
                    grid.display();
                    int x = 0;
                    try {
                        x = input.nextInt();
                    } catch (Exception exc) {
                        System.out.println("not a number between 1 and " + grid.get_xsize());
                        input.nextLine();
                    }
                    if (x > 0 && x < grid.get_xsize() + 1) {
                        x--;
                        int y = grid.find_y(x);
                        if (y != -1) {
                            if (grid.set_and_check(x, y, player)) {
                                state = 1;
                            } else if (grid.draw_game()) {
                                state = 2;
                            } else {
                                player = grid.changeplayer(player, max_players);
                            }
                        } else {
                            System.out.println("collumn filled");
                        }
                    }
                    break;
                case 1:
                    grid.display();
                    System.out.println("\nwinner is player " + player
                            + "\nPlay again?\n"
                            + "press 0 for new game\n"
                            + "press anything else to quit");
                    int choice = -1;
                    try {
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
                case 2:
                    grid.display();
                    System.out.println(
                            "\ndraw game"
                            + "\nPlay again?\n"
                            + "press 0 for new game\n"
                            + "press anything else to quit");
                    if (input.nextInt()
                            == 0) {
                        state = 0;
                        grid = new Grid();
                        player = 1;
                    } else {
                        state = -1;
                    }
                    break;
            }
        }
    }
}
