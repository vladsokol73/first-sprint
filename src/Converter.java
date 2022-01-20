public class Converter{
    int[] step;
    Converter(int[] steps){
        step = steps;
    }
    double distanseAndCal(int mounthNum, int command){
        double distance = 0;
        double ccal = 0;

        for (int i = 0; i < 30; i++){
            distance += step[i] * 75.0;
            ccal += step[i] * 50.0;
        }
        if (command == 1){
            return (distance/100000.0);
        }else{
            return (ccal/1000.0);
        }
    }
}
