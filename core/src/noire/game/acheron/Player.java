package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.Timer;

public class Player {

    private float xPos ,yPos, scaleX, scaleY;
    private int xCoor, yCoor;
    SpriteBatch batch;
    Sprite graphic;
    //private float

    public void initialize()
    {
        batch = new SpriteBatch();
        graphic = new Sprite(new Texture("sans.png"));
        graphic.setScale(0.05f);
        graphic.setCenter(graphic.getWidth()/2, graphic.getHeight()/2);
        graphic.setOrigin(graphic.getWidth()/2, graphic.getHeight()/2);
    }

    public void initTBLevel(int initialXCoor, int initialYCoor)
    {
        xCoor = initialXCoor;
        yCoor = initialYCoor;
        xPos = Tile.tileDistance + Tile.tileWidth * 0.5f + (Tile.tileWidth + Tile.tileDistance) * xCoor;
        yPos = Gdx.graphics.getHeight() - Tile.tileDistance - Tile.tileWidth * 0.5f - (Tile.tileHeight + Tile.tileDistance) * yCoor;
    }


    public void turnBasedAction(TurnBasedLevel level, TiledMap map, int turn_count) {
        TurnBasedLevel currentLevel = level;
        int turnCount = turn_count;
        int movementIndex = 1;

        if (map.playerInBound(xCoor - 1, yCoor) && Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
            setCoordinate(xCoor - 1, yCoor);
        if (map.playerInBound(xCoor + 1, yCoor) && Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
            setCoordinate(xCoor + 1, yCoor);
        if (map.playerInBound(xCoor, yCoor - 1) && Gdx.input.isKeyJustPressed(Input.Keys.UP))
            setCoordinate(xCoor, yCoor - 1);
        if (map.playerInBound(xCoor, yCoor + 1) && Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
            setCoordinate(xCoor, yCoor + 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            System.out.println(xCoor + " " + yCoor );

        /*
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            graphic.translateX(-Tile.tileWidth + 10);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            graphic.translateX(Tile.tileWidth + 10);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            graphic.translateY(Tile.tileHeight + 10);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            graphic.translateY(-Tile.tileHeight + 10);
        */
    }

    public void setPosition(float x, float y)
    {
        xPos = x;
        yPos = y;
    }

    public void setCoordinate(int xCoordinate, int yCoordinate)
    {
        xCoor = xCoordinate;
        yCoor = yCoordinate;
        xPos = Tile.tileDistance + Tile.tileWidth * 0.5f + (Tile.tileWidth + Tile.tileDistance) * xCoor;
        yPos = Gdx.graphics.getHeight() - Tile.tileDistance - Tile.tileWidth * 0.5f - (Tile.tileHeight + Tile.tileDistance) * yCoor;
    }

    public void setScale(float x, float y)
    {
        scaleX = x;
        scaleY = y;
        graphic.setScale(scaleX, scaleY);
    }
/*
    public void freeMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            xPos += -15;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            xPos += 15;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            yPos += 15;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            yPos += -15;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            setScale(0.2f, 0.2f);
    }*/

    public void render()//SpriteBatch batch)
    {
        batch.begin();
        graphic.draw(batch);
        graphic.setOriginBasedPosition(xPos, yPos);
        batch.end();
    }

    public void dispose()
    {
        batch.dispose();
    }

}
