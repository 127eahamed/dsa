import java.util.NoSuchElementException;

public class TaskManager_1_AEhan {
    private Task_1_AEhan firstTask;

    public TaskManager_1_AEhan() {
        this.firstTask = null;
    }
    public TaskManager_1_AEhan(Task_1_AEhan firstTask) {
        this.firstTask = firstTask;
    }

    public void addTask(Task_1_AEhan task) {
        if (firstTask == null) {
            firstTask = task;
            return;
        }
        if (task.getDeadline() < firstTask.getDeadline()) {
            task.setNextTask(firstTask);
            firstTask = task;
            return;
        }
        Task_1_AEhan currentTask = firstTask;
        while (currentTask.getNextTask() != null) {
            if (task.getDeadline() < currentTask.getNextTask().getDeadline()) {
                task.setNextTask(currentTask.getNextTask());
                currentTask.setNextTask(task);
                return;
            }
            currentTask = currentTask.getNextTask();
        }
        currentTask.setNextTask(task);
    }
    public Task_1_AEhan removeTask(String id) {
        Task_1_AEhan currentTask = firstTask;
        if (id.equals(firstTask.getId())) {
            firstTask = firstTask.getNextTask();
            return currentTask;
        }
        while (currentTask.getNextTask() != null) {
            if (id.equals(currentTask.getNextTask().getId())) {
                Task_1_AEhan removedTask = currentTask.getNextTask();
                currentTask.setNextTask(removedTask.getNextTask());
                return removedTask;
            }
        }
        throw new NoSuchElementException("No task found with id \"" + id + "\"");
    }
    public void displayNextTask() {
        if (firstTask != null) {
            System.out.println(firstTask);
        } else {
            System.out.println("No Tasks");
        }
    }
    public void displayAllTasks() {
        if (firstTask == null) {
            System.out.println("No Tasks");
            return;
        }
        Task_1_AEhan currentTask = firstTask;
        while (currentTask != null) {
            System.out.println(currentTask);
            currentTask = currentTask.getNextTask();
        }
    }
    public void tasksByDeadline(String deadline /* yyyy-MM-dd */) {
        /* yyyyMMdd */
        int deadlineInt = Integer.parseInt(deadline.replaceAll("-", ""));
        Task_1_AEhan currentTask = firstTask;
        boolean anyPrinted = false;
        while (currentTask != null) {
            if (currentTask.getDeadline() <= deadlineInt) {
                System.out.println(currentTask);
                anyPrinted = true;
            }
        }
        if (!anyPrinted) {
            System.out.println("No Tasks By or Earlier Than " + deadline);
        }
    }
}
