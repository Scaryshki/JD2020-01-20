package by.it.demchik.jd01_03;


import by.it.demchik.jd01_04.InOut;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
       Helper.findMin(array);
       Helper.findMax(array);


    }
}
