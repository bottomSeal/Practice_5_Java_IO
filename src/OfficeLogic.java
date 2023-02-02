import java.util.Comparator;
import java.util.Scanner;

public class OfficeLogic {

    public static void startMonth() {
        for (Employer employer: Loop.getEmployers()) {
            employer.start();
        }
    }

    public static void newHandMakeEmployer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя сотрудника: ");
        String name = scanner.nextLine();
        System.out.println("Введите фаимлию сотрудника: ");
        String surname = scanner.nextLine();
        System.out.println("Введите отчество сотрудника: ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите день рожджения сотрудника(в формате ДД.ММ.ГГГГ): ");
        String birthday = scanner.nextLine();
        System.out.println("Введите должность сотрудника: ");
        String job = scanner.nextLine();
        System.out.println("Введите город сотрудника: ");
        String city = scanner.nextLine();
        Loop.addEmployer(new Employer(name, surname, patronymic, birthday, job, city));
        System.out.println("Готово.\n");
    }

    public static void newAutoMakeEmployer() {
        Loop.addEmployer(new Employer());
    }

    public static void newHandMakeTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите описание задания: ");
        String title = scanner.nextLine();
        System.out.println("Введите сложность задания(1-10, где 1 - самое простое, 10 - самое сложное): ");
        int difficulty = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите время, требуемое для выполнения задания: ");
        int payment = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите почасовую оплату : ");
        int time = Integer.parseInt(scanner.nextLine());
        Loop.addTask(new Task(title, difficulty, payment, time));
        System.out.println("Готово.\n");
    }

    public static void newAutoMakeTask() {
        Loop.addTask(new Task());
    }

    public static void getBestTask() {
        Task bestTask = null;
        int money = 0;
        for (Task task: Loop.getAllTask()) {
            if (task.getPayment() * task.getTime() * task.getDifficulty() > money) {
                bestTask = task;
                money = task.getPayment() * task.getTime() * task.getDifficulty();
            }
        }
        System.out.println(bestTask.getTitle() + "\nЗа это задание можно получить: " +
                bestTask.getPayment() * bestTask.getTime() * bestTask.getDifficulty() + "у.е.");
    }

    public static void getTop3() {
        Loop.getEmployers().sort(Comparator.comparing(Employer::getCompletedTasks).reversed());

        System.out.println("Топ 3 лучших сотрудников по количеству выполненных заданий: ");
        System.out.println("1)" + Loop.getEmployers().get(0).getFullName() + " выполнил: " +Loop.getEmployers().get(0).getCompletedTasks());
        System.out.println("2)" + Loop.getEmployers().get(1).getFullName() + " выполнил: " +Loop.getEmployers().get(0).getCompletedTasks());
        System.out.println("3)" + Loop.getEmployers().get(2).getFullName() + " выполнил: " +Loop.getEmployers().get(0).getCompletedTasks());
    }

    public static void createReport() {
        Report.create(Loop.getCompletedTasks());
    }

    public static void saveEmployers() {
        SaveEmployer.save(Loop.getEmployers());
    }

    public static void completeTask(Employer employer, Task task) {
        System.out.println(employer.getJob() + " " + employer.getFullName() + " выполнил задание " + task.getTitle() + "\n");
        employer.setWage(employer.getWage() + task.getPayment() * task.getDifficulty() * task.getTime());
        System.out.println("Он заработал " + task.getPayment() * task.getDifficulty() * task.getTime() + " у.е.");
        employer.remove(task);
        task.setCompletedBy(employer);
        task.setCompleted(true);
        Loop.addCompletedTask(task);
    }
}
