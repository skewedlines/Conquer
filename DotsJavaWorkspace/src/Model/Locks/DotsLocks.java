package Model.Locks;

/**
 * A thread-safe(?) object that holds locks, to track the state of the game
 *
 * Created by JiaHao on 15/3/15.
 */
public class DotsLocks {

    // TODO is this class redundant? can we just put it into the DotsGame?
    // Todo not sure why i synchronise methods as well
    private boolean boardChanged;
    private boolean gameRunning;

    private int playerAffected;

    private boolean scoreNeedingUpdate;

    public DotsLocks() {
        // init as true so that the board will print it in the first time it listens for change
        this.boardChanged = true;
        this.gameRunning = true;
        this.playerAffected = -1;
    }

    public synchronized void setBoardChanged(boolean boardChanged) {

        this.boardChanged = boardChanged;
        this.notifyAll();

    }

    public synchronized boolean isGameRunning() {
        return gameRunning;
    }

    public synchronized void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public synchronized boolean isBoardChanged() {

        return this.boardChanged;
    }


    public synchronized boolean isScoreNeedingUpdate() {
        return scoreNeedingUpdate;
    }

    public synchronized void setScoreNeedingUpdate(boolean scoreNeedingUpdate) {
        this.scoreNeedingUpdate = scoreNeedingUpdate;
    }


    /**
     * Tells you if there is a need to clear the displayed moves of the affected player
     * @return -1 if no one affected, 0 for server, 1 for client
     */
    public int getPlayerAffected() {
        return playerAffected;
    }

    public void setPlayerAffected(int playerAffected) {
        this.playerAffected = playerAffected;
    }


}