public class Request{

    private static int IdCounter = 0;
    private final int ID;
    private final boolean PRIORITY;
    private final int DISC_POSITION;
    private final int ENTRY_TIME;
    private final int DEADLINE;
    private int exitTime;
    private int waitingTime;

    public Request(boolean PRIORITY,
                   int DISC_POSITION,
                   int ENTRY_TIME,
                   int DEADLINE) {
        this.ID = IdCounter;
        this.PRIORITY = PRIORITY;
        this.DISC_POSITION = DISC_POSITION;
        this.ENTRY_TIME = ENTRY_TIME;
        this.DEADLINE = DEADLINE;
        this.exitTime = 0;
        this.waitingTime = 0;

        IdCounter++;
    }



    public static int getIdCounter() {
        return IdCounter;
    }

    public static void setIdCounter(int idCounter) {
        IdCounter = idCounter;
    }

    public int getID() {
        return ID;
    }

    public int getENTRY_TIME() {
        return ENTRY_TIME;
    }

    public boolean isPRIORITY() {
        return PRIORITY;
    }

    public int getDISC_POSITION() {
        return DISC_POSITION;
    }

    public int getDEADLINE() {
        return DEADLINE;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
