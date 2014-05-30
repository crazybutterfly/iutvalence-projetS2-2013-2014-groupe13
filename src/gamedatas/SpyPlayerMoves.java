/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedatas;


public class SpyPlayerMoves extends ClassicPlayerMoves {


    public SpyPlayerMoves(ClassicPlayer player)
    {
        super(player);
    }

    @Override
    public void moveUp()
    {

        if ((this.player.getPosY() != 0) && ((this.player.getMap().getFrameStatus(this.player.getPosX(), this.player.getPosY() - 1) != Frame.WALL) && (this.player.getMap().getFrameStatus(this.player.getPosX(), this.player.getPosY() - 1) != Frame.GUARDSFLOOR)))
        {
            this.player.setPosY(this.player.getPosY() - 1);
        }
        this.player.setPlayerOrientation(PlayerOrientation.UP);
    }

    @Override
    public void moveDown()
    {
        if ((player.getPosY() != Map.MAX_Y_SIZE) && ((player.getMap().getFrameStatus(player.getPosX(), player.getPosY() + 1) != Frame.WALL) && (player.getMap().getFrameStatus(player.getPosX(), player.getPosY() + 1) != Frame.GUARDSFLOOR)))
        {
            player.setPosY(player.getPosY() + 1);
        }
        player.setPlayerOrientation(PlayerOrientation.DOWN);
    }

    @Override
    public void moveLeft()
    {
        if ((this.player.getPosX() != 0) && ((this.player.getMap().getFrameStatus(this.player.getPosX() - 1, this.player.getPosY()) != Frame.WALL) && (this.player.getMap().getFrameStatus(this.player.getPosX() - 1, this.player.getPosY()) != Frame.GUARDSFLOOR)))
        {
            this.player.setPosX(this.player.getPosX() - 1);
        }
        this.player.setPlayerOrientation(PlayerOrientation.LEFT);
    }

    @Override
    public void moveRight()
    {
        if ((this.player.getPosX() != Map.MAX_X_SIZE) && ((this.player.getMap().getFrameStatus(this.player.getPosX() + 1, this.player.getPosY()) != Frame.WALL) && (this.player.getMap().getFrameStatus(this.player.getPosX() + 1, this.player.getPosY()) != Frame.GUARDSFLOOR)))
        {
            this.player.setPosX(this.player.getPosX() + 1);
        }
        this.player.setPlayerOrientation(PlayerOrientation.RIGHT);
    }

}
