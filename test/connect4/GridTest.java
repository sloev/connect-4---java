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
     * Test of get_cells_left method, of class Grid.
     */
    @Test
    public void testGet_cells_left() {
        System.out.println("get_cells_left");
        Grid instance = new Grid();
        int expResult = 7 * 6;
        int result = instance.get_cells_left();
    }

    /**
     * Test of get_xsize method, of class Grid.
     */
    @Test
    public void testGet_xsize() {
        System.out.println("get_xsize");
        Grid instance = new Grid();
        int expResult = 7;
        int result = instance.get_xsize();
        assertEquals(expResult, result);
    }

    /**
     * Test of get_ysize method, of class Grid.
     */
    @Test
    public void testGet_ysize() {
        System.out.println("get_ysize");
        Grid instance = new Grid();
        int expResult = 6;
        int result = instance.get_ysize();
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
        int expResult = instance.get_ysize() - 1;
        int result = instance.find_y(x);
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
