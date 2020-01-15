package noire.game.acheron;

public class TurnBasedLevel extends Level {
    public TurnBasedLevel(int lvNumber, String lvName, Map map)
    {
        initialize(lvNumber, lvName, Level.TURN_BASED_LEVEL, map.type, map);
    }

    public void setMap(Map map)
    {
        this.map = map;
    }
}
