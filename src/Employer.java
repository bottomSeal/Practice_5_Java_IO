import java.util.ArrayList;
import java.util.Random;

public class Employer extends Thread {
    private static final String[] names = {"Егор", "Владимир", "Антон",
            "Артем", "Эдуард", "Николай"};
    private static final String[] surnames = {"Петров", "Иванов", "Сидоров",
            "Козлов", "Кузнецов", "Филатов"};
    private static final String[] patronymics = {"Михайлович", "Андреевич", "Антонович",
            "Эдуардович", "Петрович", "Алексеевич"};
    private static final String[] birthdays = {"22.10.2000", "15.12.1980", "20.04.1800",
            "14.26.1000", "13.12.2077", "05.03.1973"};
    private static final String[] cities = {"Тула", "Москва", "Сыктывкар",
            "Новоалтайск", "Казань", "Киров"};
    private static final String[] jobs = {"Старший сотрудник по уборке туалетов", "Электрик", "Преподаватель",
            "Клоун", "Менеджер отдела по работе с клиентами", "Секретарь"};

    private String name;
    private String surname;
    private String patronymic;
    private String birthday;
    private String city;
    private String job;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int wage = 0;
    private int completedTasks = 0;

    public void run() {
        try {
            while (tasks.size() > 0) {
                Task task = tasks.get(0);
                System.out.println("\n" + job + " " + surname + " " + name + " " + patronymic + " начал выполнять задание " + task.getTitle());
                Thread.sleep(task.getTime());
                completedTasks += 1;
                OfficeLogic.completeTask(this, task);
                if (Loop.getAllTask().size() > 0) {
                    tasks.add(Loop.getAllTask().get(0));
                    Loop.getAllTask().remove(Loop.getAllTask().get(0));
                }
            }
            this.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("\n" + job + " " + surname + " " + name + " " + patronymic + " закончил свою работу.");
    }


    Employer() {
        Random rand = new Random();
        this.name = names[rand.nextInt(6)];
        this.surname = surnames[rand.nextInt(6)];
        this.patronymic = patronymics[rand.nextInt(6)];
        this.birthday = birthdays[rand.nextInt(6)];
        this.job = jobs[rand.nextInt(6)];
        this.city = cities[rand.nextInt(6)];
        setRandomTask(rand);
    }

    Employer(String name, String surname, String patronymic, String birthday, String job, String city) {
        Random rand = new Random();
        this.surname = name;
        this.name = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.job = job;
        this.city = city;
        setRandomTask(rand);
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public void printInfo() {
        System.out.println("ФИО сотрудника: " + surname + " " + name + " " + patronymic);
        System.out.println("День рождение сотрудника: " + birthday);
        System.out.println("Должность сотрудника: " + job);
        System.out.println("Город проживания сотрудника: " + city);
        for (Task task : tasks) {
            task.printInfo();
        }
        System.out.println("\n");
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    public String getJob() {
        return job;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void remove(Task task) {
        tasks.remove(task);
    }

    private void setRandomTask(Random rand) {
        if (Loop.getAllTask().size() >= 1) {
            Task randomTask = Loop.getAllTask().get(rand.nextInt(Loop.getAllTask().size() - 1));
            tasks.add(randomTask);
            Loop.getAllTask().remove(randomTask);
        }
    }

    @Override
    public String toString() {
        return ("ФИО сотрудника: " + surname + " " + name + " " + patronymic + "\n" +
        "День рождение сотрудника: " + birthday+ "\n" +
        "Должность сотрудника: " + job + "\n" +
        "Город проживания сотрудника: " + city + "\n" +
        "Заработная плата: " + wage + "\n\n");
    }
}
