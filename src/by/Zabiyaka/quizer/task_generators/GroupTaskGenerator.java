package by.Zabiyaka.quizer.task_generators;

import by.Zabiyaka.quizer.Task;
import by.Zabiyaka.quizer.TaskGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GroupTaskGenerator implements TaskGenerator {
    private ArrayList<TaskGenerator> generators;
    private final Random random = new Random();

    public GroupTaskGenerator(TaskGenerator... generators) {
        this.generators = new ArrayList<>(Arrays.asList(generators));
    }

    public GroupTaskGenerator(List<TaskGenerator> generators) {
        this.generators = new ArrayList<>(generators);
    }

    @Override
    public Task generate() {
        return generators.get(random.nextInt(generators.size())).generate();
    }
}
