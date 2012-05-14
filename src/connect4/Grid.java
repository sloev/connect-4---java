/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author jgjpro
 */
public class Grid {

    private int xsize;
    private int ysize;
    private int max;
    private int[][] matrix;
    int cells_left = 0;

    public Grid() {
        xsize = 7;
        ysize = 6;
        max = 4;

        matrix = new int[xsize][ysize];
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                matrix[i][j] = 0;
                cells_left++;
            }
        }
    }
    //methods to gain access to internal private data
    public int[][] get_matrix() {
        return matrix;
    }

    public int get_xsize() {//returns the xsize
        return xsize;
    }

    public int get_ysize() {//returns the xsize
        return ysize;
    }

    public void display() {//prints out the matrix board
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

    public int find_y(int x) {//checks for room in collumn and returns free spot.
        int y = -1;
        for (int i = 0; i < ysize; i++) {
            if (matrix[x][i] == 0) {
                y = i;
            }
        }
        return y;
    }

    public boolean set_and_check(int x, int y, int player) {//sets the found coordinate to current player
        matrix[x][y] = player;
        cells_left--;
        return check_one(x, y, 0, 1, player) //syd
                || check_one(x, y, -1, 1, player) //sydvest
                || check_one(x, y, -1, 0, player) //vest
                || check_one(x, y, 1, 1, player);//sydøst
    }

    public boolean draw_game() {//checks for draw game
        return cells_left == 0;
    }
    //checks in one direction for 4 connected current player dots

    private boolean check_one(int x, int y, int dx, int dy, int player) {
        int count = 0;
        int tempx = x;
        int tempy = y;

        while (count < max && valid(tempx, tempy)) {
            if (matrix[tempx][tempy] != player) {
                break;

            }
            tempx += dx;
            tempy += dy;
            count++;
        }
        tempx = x - dx;
        tempy = y - dy;
        while (count < max && valid(tempx, tempy)) {
            if (matrix[tempx][tempy] != player) {
                break;

            }
            tempx -= dx;
            tempy -= dy;
            count++;
        }

        return count == max;
    }

    private boolean valid(int x, int y) {
        //if the bounds are set to be >0 only then first row and collumn 
        //doesnt work
        return x >= 0 && x < xsize && y >= 0 && y < ysize;
    }

    public int changeplayer(int player, int max_players) {
        player++;
        if (player > max_players) {
            return 1;
        }
        return player;
    }
}