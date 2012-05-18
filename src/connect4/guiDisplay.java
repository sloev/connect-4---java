/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jgjpro
 */
public class guiDisplay extends JPanel {

    private int xsize;
    private int ysize;
    private int player;
    private Grid my_grid;
    private int yoffset = 200;

    public guiDisplay(int received_xsize, int received_ysize, Grid temp_grid) {
        xsize = received_xsize;
        ysize = received_ysize;

        my_grid = temp_grid;

        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
        
        /*
         * setTitle("hello"); setSize(800, 600); setVisible(true);
         * setDefaultCloseOperation(EXIT_ON_CLOSE); setBackground(Color.BLUE);
         *
         */

    }

    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics g2 = (Graphics) g;
        //g.setColor(Color.WHITE);

        g.setColor(Color.WHITE);

        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                g.setColor(Color.WHITE);
                int xradius = this.getWidth() / xsize;
                int yradius = this.getHeight() / ysize;

                int w = (this.getWidth() / xsize) * i;
                int h = (this.getHeight() / ysize) * j;

                if (my_grid.matrix_equals(i, j, 1)) {
                    g.setColor(Color.RED);
                } else if (my_grid.matrix_equals(i, j, 2)) {
                    g.setColor(Color.GREEN);
                }
                g.fillOval(w, h, xradius, yradius);
            }
        }
    }
}
