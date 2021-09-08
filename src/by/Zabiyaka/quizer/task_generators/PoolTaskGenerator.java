package by.Zabiyaka.quizer.task_generators;

import by.Zabiyaka.quizer.Task;
import by.Zabiyaka.quizer.TaskGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PoolTaskGenerator implements TaskGenerator {
    private boolean allowDuplicate;
    private ArrayList<Task> tasks;
    private Random random;
    public PoolTaskGenerator(boolean allowDuplicate, Task... tasks) {
        this.allowDuplicate = allowDuplicate;
        this.tasks = new ArrayList<>(Arrays.asList(tasks));
    }
    public PoolTaskGenerator(boolean allowDuplicate, List<Task> tasks) {
        this.allowDuplicate = allowDuplicate;
        this.tasks = new ArrayList<>(tasks);
    }

    @Override
    public Task generate() {
        if (tasks.isEmpty()) {
            throw new RuntimeException("No tasks in Pool");
        }

        int currentTaskIndex = ThreadLocalRandom.current().nextInt();
        Task currentTask = tasks.get(currentTaskIndex);

        if (!allowDuplicate) {
            tasks.remove(currentTaskIndex);
        }
        return currentTask;
    }
}
