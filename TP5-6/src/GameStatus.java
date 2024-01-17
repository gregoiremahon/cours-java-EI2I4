public class GameStatus {
    private int status;
    
    public GameStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int newStatus) {
        this.status = newStatus;
    }

    public String toString() {
        return "GameStatus " + status;
    }
}
