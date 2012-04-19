/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class GridTest {

    public GridTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of get_xsize method, of class Grid.
     */
    @Test
    public void testGet_xsize() {
        System.out.println("get_xsize");
        Grid instance = new Grid();
        int expResult = 6;
        int result = instance.get_xsize();
        assertEquals(expResult, result);
    }

    /**
     * Test of find_y method, of class Grid.
     */
    @Test
    public void testFind_y() {
        System.out.println("find_y");
        int x = 0;
        Grid instance = new Grid();
        int expResult = 6;//ysize is 7 but the array address is 6
        int result = instance.find_y(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of set_and_check method with diagonal win, of class Grid.
     */
    @Test
    public void testSet_and_check_diagonal() {
        System.out.println("set_and_check - diagonal");

        Grid instance = new Grid();

        int player = 1;
        boolean win = false;

        while (!win) {
            for (int i = 0; i < 5; i++) {
                win = instance.set_and_check(i, instance.find_y(i), player);
                player = instance.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
        }
        boolean expResult = true;
        boolean result = win;
        assertEquals(expResult, result);
    }

    /**
     * Test of set_and_check method with horizontal win, of class Grid.
     */
    @Test
    public void testSet_and_check_horizontal() {
        System.out.println("set_and_check - horizontal");
        int player = 1;
        int xsize = 6;
        int ysize = 7;
        Grid instance = new Grid();
        boolean win = false;

        for (int i = 0; i < xsize && !win; i++) {
            for (int u = 0; u < 2; u++) {
                win = instance.set_and_check(i, instance.find_y(i), player);
                player = instance.changeplayer(player, 2);

                if (win) {
                    break;
                }
            }
        }
        boolean expResult = true;
        boolean result = win;
        assertEquals(expResult, result);
    }

    /**
     * Test of set_and_check method with vertical win, of class Grid.
     */
    @Test
    public void testSet_and_check_vertical() {
        System.out.println("set_and_check - vertical");
        int xsize = 6;
        int ysize = 7;
        int player = 1;
        Grid instance = new Grid();
        boolean win = false;
        while (!win) {
            for (int i = 0; i < xsize; i++) {
                win = instance.set_and_check(i, instance.find_y(i), player);
                player = instance.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
        }

        boolean expResult = true;
        boolean result = win;
        assertEquals(expResult, result);
    }

    /**
     * Test of draw_game method, of class Grid.
     */
    @Test
    public void testDraw_game() {
        System.out.println("draw_game");

        int player = 1;
        int xsize = 6;
        int ysize = 7;
        boolean win = false;
        Grid instance = new Grid();
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                win = instance.set_and_check(i, instance.find_y(i), player);
                player = instance.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
            ysize--;
        }
        for (int i = 0; i < xsize; i++) {
            while (instance.find_y(i) != -1) {
                win = instance.set_and_check(i, instance.find_y(i), player);
                player = instance.changeplayer(player, 2);
                if (win) {
                    break;
                }
            }
        }
        boolean expResult = true;
        boolean result = instance.draw_game();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeplayer method, of class Grid.
     */
    @Test
    public void testChangeplayer() {
        System.out.println("changeplayer");
        int player = 1;
        int max_players = 2;
        Grid instance = new Grid();

        int expResult = 2;
        int result = instance.changeplayer(player, max_players);
        assertEquals(expResult, result);
    }
}
