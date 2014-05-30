package gamecore;

import java.io.IOException;

public class GameLauncher {

    public static void main(String[] args) throws IOException
    {

        /**
         * The game engine.
         */
        Engine gameEngine;

        /**
         * the initial game informations
         */
        GameInformations initialGameInformations;

        // Game informations creation
        initialGameInformations = new GameInformations();
        // Game informations parameter
        initialGameInformations.setParameters();
        // Game engine creation
        gameEngine = new Engine(initialGameInformations);
        // Game launch
        gameEngine.startGame();


    }

    private void gameStart(GameInformations gameInfos)
    {
    }

    private void teamSelect(GameInformations gameInfos)
    {
    }

}
