package OOD.Elevator;

public class Elevator {
    private int currentFloor;
    private int targetFloor;
    private int status;
    private static volatile Elevator instance = null;

    private Elevator() {
        this.currentFloor = 0;
        this.targetFloor = 0;
        this.status = 0;
    }
    public static Elevator getInstance() {
        if (instance == null) {
            synchronized(Elevator.class) {
                if (instance == null) {
                    instance = new Elevator();
                }
            }
        }
        return instance;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getStatus() {
        return status;
    }
    public void moveToFloor(int targetFloor) {
        while (currentFloor < targetFloor) {
            moveUp();
        }
        while (currentFloor > targetFloor) {
            moveDown();
        }
        status = 0;
    }
    private void moveUp() {
        status = 1;
        currentFloor += 1;
    }
    private void moveDown() {
        status = -1;
        currentFloor -= 1;
    }
}
