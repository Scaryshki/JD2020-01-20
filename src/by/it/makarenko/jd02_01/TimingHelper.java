package by.it.makarenko.jd02_01;

import java.util.Random;

class TimingHelper {

    private static Random generator = new Random(12);

    static void sleep(int timeOut){

        try {
            Thread.sleep(timeOut/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("Crash of Thread:(");
        }
    }

    static int random(int min, int max){
        return generator.nextInt(max-min+1)+min;
    }

    static int random(int max){
        return random(0, max);
    }
}
