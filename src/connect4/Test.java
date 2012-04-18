package connect4;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author jgjpro
 */
public class Test {

    Grid test_grid;
    int x;
    int y;
    int xsize;
    int ysize;
    int player;

    public Test() {
        test_grid = new Grid();
        x = 0;
        xsize = 6;
        ysize = 7;

        drawgame(ysize);
        diagonal();
        horizontal();
        vertical();
    }

    private void drawgame(int ysize) {
        player = 1;
        boolean win = false;
        test_grid = new Grid();
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                win = test_grid.set_and_check(i, test_grid.find_y(i), player);
                player = test_grid.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
            ysize--;
        }
        for (int i = 0; i < xsize; i++) {
            while (test_grid.find_y(i) != -1) {
                win = test_grid.set_and_check(i, test_grid.find_y(i), player);
                player = test_grid.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
        }
        test_grid.display();

        System.out.println("test drawgame = " + (test_grid.draw_game() == true)); //true if test is ok
    }

    private void diagonal() {
        test_grid = new Grid();
        player = 1;
        boolean win = false;
        while (!win) {
            for (int i = 0; i < 5; i++) {
                win = test_grid.set_and_check(i, test_grid.find_y(i), player);
                player = test_grid.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
        }
        test_grid.display();
        System.out.println("test diagonal = " + (win == true));//true if test is ok

    }

    private void horizontal() {
        test_grid = new Grid();
        player = 1;
        boolean win = false;

        for (int i = 0; i < xsize && !win; i++) {
            for (int u = 0; u < 2; u++) {
                win = test_grid.set_and_check(i, test_grid.find_y(i), player);
                player = test_grid.changeplayer(player, 2);

                if (win) {
                    break;
                }
            }
        }

        test_grid.display();
        System.out.println("test horizontal = " + (win == true));//true if test is ok

    }

    private void vertical() {
        test_grid = new Grid();
        player = 1;
        boolean win = false;
        while (!win) {
            for (int i = 0; i < xsize; i++) {
                win = test_grid.set_and_check(i, test_grid.find_y(i), player);
                player = test_grid.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
        }
        test_grid.display();
        System.out.println("test vertical = " + (win == true));//true if test is ok

    }
}
