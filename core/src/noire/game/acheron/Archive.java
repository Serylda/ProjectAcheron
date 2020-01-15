package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;

public class Archive {

    public ArrayList<Level> levels;
    public ArrayList<Map> maps;

    public void createMaps()
    {
        TiledMap testMap = new TiledMap(Gdx.files.internal("maps/testMap.txt"));
    }


    public void loadLevels() {
        levels = new ArrayList<Level>();
        levels.add(new TurnBasedLevel(1, "testLevel", new TiledMap(Gdx.files.internal("maps/testMap.txt"))));
        //levels.get(0).

    }

}
