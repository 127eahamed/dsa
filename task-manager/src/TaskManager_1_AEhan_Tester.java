public class TaskManager_1_AEhan_Tester {
    public static void main(String[] args) {
        TaskManager_1_AEhan taskManager = new TaskManager_1_AEhan();
        System.out.println("(new empty task manager)");
        System.out.println();
        System.out.println("display next task:");
        taskManager.displayNextTask();
        System.out.println();
        System.out.println("display all tasks:");
        taskManager.displayAllTasks();
        System.out.println();
        System.out.println("display tasks by 2009-01-19:");
        taskManager.tasksByDeadline("2009-01-19");
        System.out.println();
        System.out.println("(add new task with deadline on 2025-01-12)");
        taskManager.addTask(new Task_1_AEhan(
                "task id i guess?",
                "Finish LinkedList Programming Assignment",
                20250112
        ));
        System.out.println();
        System.out.println("display next task:");
        taskManager.displayNextTask();
        System.out.println();
        System.out.println("display all tasks:");
        taskManager.displayAllTasks();
        System.out.println();
        System.out.println("display tasks by 2009-01-19:");
        taskManager.tasksByDeadline("2009-01-19");
        System.out.println();
        System.out.println("display tasks by 2025-01-12:");
        taskManager.tasksByDeadline("2025-01-12");
        System.out.println();
        System.out.println("display tasks by 2025-02-01:");
        taskManager.tasksByDeadline("2025-02-01");
        System.out.println();
        System.out.println("(add new task with deadline on 2025-01-01)");
        taskManager.addTask(new Task_1_AEhan(
                "task id again?",
                "Example Task",
                20250101
        ));
        System.out.println();
        System.out.println("display next task:");
        taskManager.displayNextTask();
        System.out.println();
        System.out.println("display all tasks:");
        taskManager.displayAllTasks();
        System.out.println();
        System.out.println("display tasks by 2009-01-19:");
        taskManager.tasksByDeadline("2009-01-19");
        System.out.println();
        System.out.println("display tasks by 2025-01-02:");
        taskManager.tasksByDeadline("2025-01-02");
        System.out.println();
        System.out.println("(remove task with id \"task id again?\")");
        taskManager.removeTask("task id again?");
        System.out.println();
        System.out.println("display all tasks:");
        taskManager.displayAllTasks();
        System.out.println();
    }
}
