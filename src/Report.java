import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Report {
    public static void create(ArrayList<Task> tasks) {
        try (FileWriter fileWriter = new FileWriter("report.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for (Task task: tasks) {
                bufferedWriter.write(task.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}