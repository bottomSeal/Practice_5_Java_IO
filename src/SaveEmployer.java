import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveEmployer {
    public static void save(ArrayList<Employer> employers) {
        try (FileWriter fileWriter = new FileWriter("employers.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for (Employer employer: employers) {
                bufferedWriter.write(employer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
