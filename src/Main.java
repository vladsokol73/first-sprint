import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        stepTracker.init();

        System.out.println("Добро пожаловать в Счётчик калорий!");
        printMenu();
        int command = scanner.nextInt();

        while (true) {
            if (command == 1) {
                System.out.println("Введите номер месяца от 1 до 12:");
                int monthNum;
                if (scanner.hasNextInt()) {
                    monthNum = scanner.nextInt() -1;
                } else {
                    System.out.println("Вы ввели не число");
                    continue;
                }System.out.println("Введите номер дня от 1 до 30:");
                int dayNum;
                if (scanner.hasNextInt()) {
                    dayNum = scanner.nextInt() -1;
                } else {
                    System.out.println("Вы ввели не число");
                    continue;
                }System.out.println("Введите количество пройденных шагов:");
                int steps;
                if (scanner.hasNextInt()) {
                    steps = scanner.nextInt();
                } else {
                    System.out.println("Вы ввели не число");
                    continue;
                }
                stepTracker.stepAdd(monthNum, dayNum, steps);

            }else if (command == 2) {
                System.out.println("Введите номер месяца от 1 до 12:");
                int mounthName = scanner.nextInt() -1;
                stepTracker.statistic(mounthName);
            }else if (command == 3) {
                System.out.println("Введите новую цель.");
                int stepcount = scanner.nextInt();
                stepTracker.stepCount(stepcount);
            }else if (command == 0) {
                System.out.println("Выход :(");
                break;
            }else {
                System.out.println("Извините, такой команды пока нет.");
            }

            printMenu();
            command = scanner.nextInt();
        }
    }
    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество пройденных шагов за день.");
        System.out.println("2 - Посмотреть статистику за выбранный месяц");
        System.out.println("3 - Изменить цель по количеству шагов за день");
        System.out.println("0 - Выйти из приложения");
    }
}
