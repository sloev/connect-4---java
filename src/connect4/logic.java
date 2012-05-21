package connect4;

public class logic {

    private int cells_left = 0;
    private int max;
    private int xsize;
    private int ysize;
    Grid my_grid;

    public logic(Grid tempGrid) {
        max = 4;//connect 4 or n
        my_grid = tempGrid;
        cells_left = my_grid.get_cells_left();
        xsize = my_grid.get_xsize();
        ysize = my_grid.get_ysize();
    }

    public boolean set_and_check(int x, int y, int player) {//sets the found coordinate to current player
        my_grid.set_matrix(x, y, player);
        cells_left--;
        return check_one(x, y, 0, 1, player) //syd
                || check_one(x, y, -1, 1, player) //sydvest
                || check_one(x, y, -1, 0, player) //vest
                || check_one(x, y, 1, 1, player);//sydøst
    }

    public boolean draw_game() {//checks for draw game
        return cells_left == 0;
    }

    private boolean check_one(int x, int y, int dx, int dy, int player) {
        int count = 0;
        int tempx = x;
        int tempy = y;

        while (count < max && valid(tempx, tempy)) {
            if (!my_grid.matrix_equals(tempx, tempy, player)) {
                break;

            }
            tempx += dx;
            tempy += dy;
            count++;
        }
        tempx = x - dx;
        tempy = y - dy;
        while (count < max && valid(tempx, tempy)) {
            if (!my_grid.matrix_equals(tempx, tempy, player)) {
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
}
