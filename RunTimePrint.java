package common;

public class RunTimePrint {
    private long startTime;
    private long endTime;

    public RunTimePrint() {
        startTime = 0;
        endTime = 0;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }

    public void printRuntime() {
        System.out.printf("Runtime: %dms\n", this.endTime-this.startTime);
    }
}
