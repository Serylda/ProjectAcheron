package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends MapElement
{

    private int state, modifier;

    private Sprite graphic;
    private Texture tileTexture;

    public static final int DEFAULT = 0;
    public static final int EMPTY = 1;
    public static final int OCCUPIED_BY_PLAYER = 2;
    public static final int OCCUPIED_BY_OBSTACLE = 3;

    public static final int SPAWN_POINT = 4;
    public static final int PORTAL = 5;

    public static final float tileWidth = 100;
    public static final float tileHeight = 100;
    public static final float tileDistance = 5;

    Sprite tile_Empty, tile_Player, tile_Obstacle;

    public Tile(int state)
    {
        initialize(state);
        xScale = 1f;
        yScale = 1f;
        //System.out.println(xPos + " " + yPos);
    }

    public Tile(int state, int yCoordinate, int xCoordinate)
    {
        initialize(state, xCoordinate, yCoordinate);
        xScale = 1f;
        yScale = 1f;
        //System.out.println(Gdx.graphics.getHeight() + " " + Gdx.graphics.getWidth());
    }

    public Tile(int state, int modifier, int yCoordinate, int xCoordinate)
    {
        initialize(state, xCoordinate, yCoordinate);
        this.modifier = modifier;
    }

    public void initialize(int s)
    {
        state = s;
        modifier = DEFAULT;

        tileTexture = new Texture("atlasTile.png");

        tile_Empty = new Sprite(tileTexture,0, 0, 100,100);
        tile_Obstacle = new Sprite(tileTexture,200, 0, 100,100);
        tile_Player = new Sprite(tileTexture, 100, 0, 100, 100);

        graphic = new Sprite(tile_Empty);

        switch (state)
        {
            case (EMPTY):
                graphic.set(tile_Empty);
                break;
            case (OCCUPIED_BY_OBSTACLE):
                graphic.set(tile_Obstacle);
                break;
            case (OCCUPIED_BY_PLAYER):
                graphic.set(tile_Player);
                break;
            default:
                graphic.set(tile_Empty);
                break;
        }
    }

    public void initialize(int s, int xCoordinate, int yCoordinate)
    {
        initialize(s);

        setCoordinate(xCoordinate, yCoordinate);

    }

    public void setCoordinate(int xCoordinate, int yCoordinate)
    {
        xCoor = xCoordinate;
        yCoor = yCoordinate;
        xPos = tileDistance + (tileWidth + tileDistance) * xCoor;
        yPos = Gdx.graphics.getHeight() - 100 - tileDistance - (tileHeight + tileDistance) * yCoor;
    }

    public boolean occupiable()
    {
        return state == EMPTY;
    }

    public void setPos(float x, float y)
    {
        xPos = x;
        yPos = y;
    }

    public void setScale(float x, float y)
    {
        xScale = x;
        yScale = y;
    }

    public void setState(int state)
    {
        this.state = state;
        switch (state)
        {
            case (EMPTY):
                graphic.set(tile_Empty);
                break;
            case (OCCUPIED_BY_OBSTACLE):
                graphic.set(tile_Obstacle);
                break;
            case (OCCUPIED_BY_PLAYER):
                graphic.set(tile_Player);
                break;
            default:
                graphic.set(tile_Empty);
                break;
        }
    }


    public String toString()
    {
        return state + "";
    }

    public void renderElement(SpriteBatch batch)
    {
        batch.begin();
        graphic.setPosition(xPos, yPos);
        //graphic.setScale(xScale, yScale);
        graphic.draw(batch);
        batch.end();
    }
}
