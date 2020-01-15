package noire.game.acheron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public abstract class Level {

    //public Stage stage;

    protected int levelNumber;
    protected String levelName;
    protected int levelType;
    protected int mapType;

    protected int bgm;

    public static final int TURN_BASED_LEVEL = 0;
    public static final int EXPLORATION_LEVEL = 1;
    public static final int BOSS_FIGHT_LEVEL = 2;

    protected Map map;

    public void initialize(int lvNumber, String lvName, int lvType, int mpType, Map mp)
    {
        //stage = new Stage(new ScreenViewport());
        //Gdx.input.setInputProcessor(stage);

        levelNumber = lvNumber;
        levelName = lvName;
        levelType = lvType;
        mapType = mpType;
        map = mp;
    }

    public Map map()
    {
        return map;
    }

    public String levelCode()
    {
            String code = "";
            code += String.format("%03d", levelNumber) + "-";

            switch (map.getType()) {
                case (Map.TILED_MAP):
                    code += "T";
                    break;
                case (Map.FREE_MAP):
                    code += "F";
                    break;
            }

            switch (levelType) {
                case (TURN_BASED_LEVEL):
                    code += "T";
                    break;
                case (EXPLORATION_LEVEL):
                    code += "E";
                    break;
                case (BOSS_FIGHT_LEVEL):
                    code += "B";
                    break;
            }
            return code;
    }
}
