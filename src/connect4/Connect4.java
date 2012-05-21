package connect4;

public class Connect4 {

    public static void main(String[] args) {
        int state = 0;
        boolean useGui = true;//sets if we want the cli or gui.

        if (useGui) {
            gui Gui = new gui();
            while (state != -1) {//checks if program is in quitting stage
                switch (state) {
                    case 0://runtime
                        Gui.updateBoard();
                        if (Gui.getHasWon()) {
                            state = 1;
                        } else if (Gui.getHasDraw()) {
                            state = 2;
                        } else if (Gui.getNewGame()) {
                            Gui = new gui();
                            state = 0;
                        }
                        break;
                    case 1://endgame with winner
                        Gui.showWon();
                        if (Gui.getQuit()) {
                            state = -1;
                        } else  if (Gui.getNewGame()) {
                            Gui = new gui();
                            state = 0;
                        }
                        break;
                    case 2://endgame with drawgame
                        Gui.showDraw();
                        if (Gui.getQuit()) {
                            state = -1;
                        } else if (Gui.getNewGame()) {
                            Gui = new gui();
                            state = 0;
                        }
                        break;
                }
            }
        } else {
            cli Cli = new cli();
            while (state != -1) {//checks if program is in quitting stage
                switch (state) {
                    case 0:
                        Cli.runtime();
                        if (Cli.getHasWon()) {
                            state = 1;
                        } else if (Cli.getHasDraw()) {
                            state = 2;
                        }
                        break;
                    case 1://prints endgame with winner
                        Cli.showWin();
                        if (Cli.getQuit()) {
                            state = -1;
                        } else if (Cli.getNewGame()) {
                            Cli = new cli();
                            state = 0;
                        }
                        break;
                    case 2://prints end game eith draw game
                        Cli.showDraw();
                        if (Cli.getQuit()) {
                            state = -1;
                        } else if (Cli.getNewGame()) {
                            Cli = new cli();
                            state = 0;
                        }
                        break;
                }
            }
        }
    }
}
