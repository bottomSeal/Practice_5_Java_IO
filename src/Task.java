import java.util.Random;

public class Task {
    private static final String [] actions = {"Принести", "Выполнить", "Сдать",
            "Выучить", "Подготовить", "Проанализировать"};
    private static final String [] objects = {"5-ую практику по Java", "билеты по мат. анализу",
            "тех. анализ акций ББСО-01-21", "экзамен по англ. языку", "домашнее задание", "ремонт автомобиля"};

    private String title;
    private int difficulty;
    private int payment;
    private int time;
    private boolean isCompleted = false;
    private Employer completedBy;

    public Task() {
        Random rand = new Random();
        this.title = actions[rand.nextInt(6)] + " " + objects[rand.nextInt(6)] + ".";
        this.difficulty = rand.nextInt(1, 10);
        this.payment = rand.nextInt(1, 1000);
        this.time = rand.nextInt(1, 720);
    }

    public Task(String title, int difficulty, int payment, int time) {
        this.title = title;
        this.difficulty = difficulty;
        this.payment = payment;
        this.time = time;
    }

    public void printInfo() {
        System.out.println("\nОписание задания: " + title);
        System.out.println("Сложность задания: " + difficulty);
        System.out.println("Время, требуемое на выполнение: " + time + " часов");
        System.out.println("Почасовая оплата: " + payment + " руб./ч.");
        if (isCompleted) {
            System.out.println("Выполнено работником: " + completedBy.getFullName());
        } else {
            System.out.println("Задание открыто\n");
        }
    }

    public int getTime() {
        return time;
    }

    public int getPayment() {
        return payment;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getTitle() {
        return title;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setCompletedBy(Employer completedBy) {
        this.completedBy = completedBy;
    }

    @Override
    public String toString() {
        String status;
        if (isCompleted) {
            status = "Выполнено работником: " + completedBy.getFullName();
        } else {
            status ="Задание открыто\n";
        }
        return ("Описание задания: " + title + "\n" +
        "Сложность задания: " + difficulty + "\n" +
        "Время, требуемое на выполнение: " + time + " часов" + "\n" +
        "Почасовая оплата: " + payment + " руб./ч." + "\n" + status + "\n\n");
    }
}
