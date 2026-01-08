public class TaskManager_1_AEhan {
    private Task_1_AEhan firstTask;

    public TaskManager_1_AEhan(Task_1_AEhan firstTask) {
        this.firstTask = firstTask;
    }

    public void addTask(Task_1_AEhan task) {
        Task_1_AEhan currentTask = firstTask;
        if
        while (currentTask.getNextTask() != null) {
            if (currentTask.getNextTask().getDeadline() > task.getDeadline()) {
                task.setNextTask(currentTask.getNextTask());
                currentTask.setNextTask(task);
                return;
            }
            currentTask = currentTask.getNextTask();
        }
        currentTask.setNextTask(task);
    }
}
