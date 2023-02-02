import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startMenu() {
        if (this.scanner != null) {
            int key;
            try {
                do {
                    System.out.println("\n1. Показать список всех сотрудников");
                    System.out.println("2. Просмотр списка заданий");
                    System.out.println("3. Ввод нового сотрудника вручную");
                    System.out.println("4. Добавление сотрудника из случайных данных");
                    System.out.println("5. Добавление задания вручную");
                    System.out.println("6. Добавление задания из случайных данных");
                    System.out.println("7. Вывод топ-3 сотрудников по выполнению заданий в месяц");
                    System.out.println("8. Вывод задания с наибольшим гонораром за выполнение");
                    System.out.println("9. Формирование отчета о выполненных заданиях");
                    System.out.println("10. Запись данных о сотрудниках в файл");
                    System.out.println("11. Запуск нового месяца");
                    System.out.println("12. Завершение программы");
                    System.out.print("Введите номер меню: ");
                    key = this.scanner.nextInt();
                    System.out.println("\n");
                    switch (key) {
                        case 1:
                            View.printEmployers(Loop.getEmployers());
                            break;
                        case 2:
                            View.printTasks(Loop.getAllTask());
                            View.printTasks(Loop.getCompletedTasks());
                            break;
                        case 3:
                            OfficeLogic.newHandMakeEmployer();
                            break;
                        case 4:
                            OfficeLogic.newAutoMakeEmployer();
                            break;
                        case 5:
                            OfficeLogic.newHandMakeTask();
                            break;
                        case 6:
                            OfficeLogic.newAutoMakeTask();
                            break;
                        case 7:
                            OfficeLogic.getTop3();
                            break;
                        case 8:
                            OfficeLogic.getBestTask();
                            break;
                        case 9:
                            OfficeLogic.createReport();
                            break;
                        case 10:
                            OfficeLogic.saveEmployers();
                            break;
                        case 11:
                            OfficeLogic.startMonth();
                            break;
                    }
                } while (key != 12);
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверные данные.\n");
                new MainMenu(new Scanner(System.in)).startMenu();
            }
        }
    }
}
