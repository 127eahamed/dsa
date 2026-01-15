public class Task_1_AEhan {
    private String id;
    private String description;
    private int deadline; /* yyyyMMdd, displayed as yyyy-MM-dd in toString() */
    private Task_1_AEhan nextTask;

    public Task_1_AEhan(String id, String description, int deadline) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public int getDeadline() {
        return deadline;
    }
    public Task_1_AEhan getNextTask() {
        return nextTask;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
    public void setNextTask(Task_1_AEhan nextTask) {
        this.nextTask = nextTask;
    }

    public String toString() {
        String deadlineString = "" + deadline;
        deadlineString = deadlineString.substring(0, 4) + "-" + deadlineString.substring(4, 6) + "-" + deadlineString.substring(6);
        return "id: " + id + ", description: " + description + ", deadline: " + deadlineString;
    }
}
