public class GenerateLogic {
    public static void generateEmployers(int number) {
        for (int i = 0; i < number; i++) {
            Loop.addEmployer(new Employer());
        }
    }

    public static void generateTask(int number) {
        for (int i = 0; i < number; i++) {
            Loop.addTask(new Task());
        }
    }
}
