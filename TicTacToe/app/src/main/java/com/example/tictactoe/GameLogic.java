package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {

    private int[][] gameBoard;

    public Button getPlayerAgainBTN() {
        return playerAgainBTN;
    }

    public void setPlayerAgainBTN(Button playerAgainBTN) {
        this.playerAgainBTN = playerAgainBTN;
    }

    public Button getHomeBTN() {
        return homeBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }


    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    private Button playerAgainBTN;
    private Button homeBTN;

    public TextView getPlayerTurn() {
        return playerTurn;
    }

    private TextView playerTurn;

    public String[] getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    private String[] playerNames = {"Player 1", "Player 2"};

    // row, col,  3rd element -> line type
    private int[] winType = {-1, -1, -1};

    private int player = 1;

    GameLogic() {
        gameBoard = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col) {
        if (gameBoard[row - 1][col - 1] == 0) {
            gameBoard[row - 1][col - 1] = player;

            if (player == 1) {
                playerTurn.setText(playerNames[1] + "'s Turn");
            } else {
                playerTurn.setText(playerNames[0] + "'s Turn");
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean winnerCheck() {

        boolean isWinner = false;

        // Horizontal check
        for (int r = 0; r < 3; r++) {
            if (0 != gameBoard[r][0] && gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2]) {
                isWinner = true;
                winType = new int[]{r, 0, 1};
            }
        }


        for (int c = 0; c < 3; c++) {
            if (0 != gameBoard[0][c] && gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c]) {
                isWinner = true;
                winType = new int[] {0, c, 2};
            }
        }

        if (gameBoard[0][0] != 0 && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) {
            isWinner = true;
            winType = new int[] {0, 2, 3};
        }

        if (gameBoard[0][2] != 0 && gameBoard[0][2] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[1][1]) {
            isWinner = true;
            winType = new int[] {0,0,4};
        }

        int boardFilled = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (gameBoard[r][c] != 0) {
                    boardFilled++;
                }
            }
        }

        if (isWinner) {
            playerAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player - 1] + " Won!!!!!!"));
            return true;
        } else if (boardFilled == 9) {
            playerAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText("Tie Game!!!!!!");
            return false;
        } else {
            return false;
        }
    }


    public void resetGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }

        player = 1;
        playerAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        playerTurn.setText((playerNames[0]) + "'s Turn");
    }


    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
