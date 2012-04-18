/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.util.Scanner;

/**
 *
 * @author jgjpro
 */
public class Connect4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int state = 0;
        int max_players = 2;
        int player = 1;

        Grid grid = new Grid();

        Scanner input = new Scanner(System.in);
        
        if (args.length > 0 && args[0].equals("test")) {//if cli arguments is test then
            Test test = new Test();
        } else {
            while (state != -1) {
                switch (state) {
                    case 0:
                        System.out.println("player " + player + "'s turn");
                        grid.display();
                        int x = input.nextInt();
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
                        } else {
                            System.out.println("number must be > 0 < " + (grid.get_xsize() + 1));
                        }

                        break;
                    case 1:

                        grid.display();
                        if (grid.draw_game()) {
                        } else {
                            System.out.println("\nwinner is player " + player
                                    + "\nPlay again?\n"
                                    + "press 0 for new game\n"
                                    + "press anything else to quit");
                        }
                        if (input.nextInt() == 0) {
                            state = 0;
                            grid = new Grid();
                            player = 1;
                        } else {
                            state = -1;
                        }

                        break;
                    case 2:

                        grid.display();
                        System.out.println("\ndraw game"
                                + "\nPlay again?\n"
                                + "press 0 for new game\n"
                                + "press anything else to quit");

                        if (input.nextInt() == 0) {
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
}
