/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author jgjpro
 */
public class cliDisplay {

    private int xsize;
    private int ysize;

    public cliDisplay(int received_xsize, int received_ysize) {
        xsize = received_xsize;
        ysize = received_ysize;
    }

    public void display(int[][] matrix) {//prints out the matrix board
        for (int i = -1; i < ysize; i++) {
            for (int j = 0; j < xsize; j++) {
                if (i < 0) {
                    System.out.print(" " + (j + 1) + " ");
                } else {
                    System.out.print("[");
                    if (matrix[j][i] == 0) {
                        System.out.print(" ]");
                    } else {
                        System.out.print(matrix[j][i] + "]");
                    }
                }
            }
            System.out.println();
        }
    }
}
