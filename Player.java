public class Player
{
    private int playerId;
    private String playerName;
    private int playerPosition;
    Player(int playerId, String playerName)
    {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerPosition = 0;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public int getPlayerPosition()
    {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition)
    {
        this.playerPosition = playerPosition;
    }
}
