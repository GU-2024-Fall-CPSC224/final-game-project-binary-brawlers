package edu.gonzaga;



public class Game {

    private Board board;

    private boolean playGame = false;
    private boolean snakeDeath = false;

    private void startGame() {

    }

    private void checkGameOver() {    
        if (snakeDeath) {
            gameOver();
        }
    }

    private void gameOver() {
        // String[] options = {"Try Again", "Menu", "Exit"};
        // var choice = JOptionPane.showOptionDialog(this, "GAME OVER", "Snake Game", 0, 3, null, options, options[0]);

        // WILL IMPLEMENT ONCE BOARDS HAVE BEEN CREATED
        // try again
        // if (choice == 0) {
        //     resetGame();
        // }
        // // go to menu
        // if (choice == 1) {
        //     exitGame();
        // }
        // // close window
        // if (choice == 2) {
        //     System.exit(0);
        // }
    }

    // private void resetGame() {
    //     playGame = false;
    //     snakeDeath = false;
    //     board = new Board();
    //     startMenu((JFrame) this.getTopLevelAncestor());
    // }
    
    // private exitGame() {
    //     JFrame frame = (JFrame) this.getTopLevelAncestor();

    //     if (frame != null) {
    //         frame.getContentPane().removeAll();
    //         startMenu(frame);
    //         frame.revalidate();
    //     }
    // }

}
