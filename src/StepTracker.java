import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, int[]> stepList;
    int countStep = 10000;

    void init (){
        for(int i = 0; i < 12; i++) {
            int[] list = new int[30];
            for(int j = 0; j < 30; j++){
                list[i] = 0;
            }
            stepList.put(i, list);
        }
    }

    StepTracker(){
        stepList = new HashMap<>();
    }

    void stepAdd(int monthNum, int dayNum, int steps){
        int[] lists = stepList.get(monthNum);
        lists[dayNum] += steps;
        System.out.println("Успешно добавлено");
    }

    void stepCount(int countstep){
        countStep = countstep;
        System.out.println("Успешно обновлено");
    }

    void statistic(int mounthNum){
        int[] lists = stepList.get(mounthNum);
        Converter converter = new Converter(lists);
        System.out.print(1 + " день: " + lists[0]);
        for(int i = 1; i < 29; i++){
            System.out.print(", " + (i+1) + " день: " + lists[i]);
        }
        System.out.println(", " + 30 + " день: " + lists[29]);
        int stepSum = 0;
        int stepSerie = 0;
        int step1 = 0;
        int stepMax = 0;
        for(int i = 0; i < 30; i++) {
            stepSum += lists[i];
            if (lists[i] > stepMax) {
                stepMax = lists[i];
            }
            if (lists[i] >= countStep) {
                step1 += 1;
            } else {
                if (step1 > stepSerie) {
                    stepSerie = step1;
                }
                step1 = 0;
            }
        }int stepMid = stepSum/30;
        System.out.println("За месяц вы прошли: " + stepSum + " шагов.");
        System.out.println("Среднее количество шагов за день составило: " + stepMid);
        System.out.println("Максимальное количество шагов за день составило: " + stepMax);
        System.out.println("Пройдена дистанция: " + converter.distanseAndCal(mounthNum, 1) + "км.");
        System.out.println("Сожжено калорий: " + converter.distanseAndCal(mounthNum, 2) + "ккал.");
        System.out.println("Лучшая серия выполнения цели по шагам составила: " + stepSerie + " дней.");
    }
}