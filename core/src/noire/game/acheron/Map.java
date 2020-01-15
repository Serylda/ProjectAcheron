package noire.game.acheron;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Map {

    protected int type;

    public static final int TILED_MAP = 1;
    public static final int FREE_MAP = 2;

    public int getType()
    {return type;}

    public abstract void renderMap(SpriteBatch batch);
}
