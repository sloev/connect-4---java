/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author jgjpro
 */
public class logicTest {

    public logicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of set_and_check method, of class logic.
     */
    @Test
    public void testSet_and_check() {
        System.out.println("set_and_check");
        int x = 0;
        int y = 0;
        int player = 1;
        Grid tempGrid = new Grid();
        logic instance = new logic(tempGrid);
        boolean expResult = false;
        boolean result = instance.set_and_check(x, y, player);
        assertEquals(expResult, result);
    }

    /**
     * Test of draw_game method, of class logic.
     */
    @Test
    public void testDraw_game() {
        System.out.println("draw_game");
        //     boolean win = false;
        int player = 1;
        int xsize = 7;
        int ysize = 6;

        Grid tempGrid = new Grid();
        logic instance = new logic(tempGrid);

        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                if (instance.set_and_check(i, tempGrid.find_y(i), player)) {
                    player = tempGrid.changeplayer(player, 2);
                    break;
                } else {
                    player = tempGrid.changeplayer(player, 2);
                }
            }
            ysize--;
        }

        for (int i = 0; i < xsize; i++) {
            while (tempGrid.find_y(i) != -1) {
                if (instance.set_and_check(i, tempGrid.find_y(i), player)) {
                    player = tempGrid.changeplayer(player, 2);
                    break;
                } else {
                    player = tempGrid.changeplayer(player, 2);
                }
            }
        }

        boolean expResult = true;
        boolean result = instance.draw_game();
        assertEquals(expResult, result);
    }
}
