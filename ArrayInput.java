package uni.informatics;

import java.util.Scanner;

public class ArrayInput {
    public static final Scanner scanner = new Scanner(System.in);
    public static int[] arrayNumberCreation(int[] array){
        boolean isArrayInputStillGoing = true;
        while (isArrayInputStillGoing){
            System.out.println();
            System.out.println("Въведете колко на брой числа ще въвеждате");
            int sizeOfArray = scanner.nextInt();
            if (sizeOfArray <= 0){
                System.err.println("Броя на числата не може да е по-малък от 1");
                continue;
            }
            array = new int[sizeOfArray];
            System.out.println("Въведете числа от 0 до 10000");
            for (int i=0;i<sizeOfArray;i++){
                array[i] = scanner.nextInt();
                if (array[i] < 0 || array[i] > 100){
                    System.err.println("Опитайте пак с число между 0 и 10000");
                    i--;
                }
            }
            isArrayInputStillGoing=false;
        }
        return array;
    }
    public static String[] arrayStringCreation(String[] array){
        boolean isArrayInputStillGoing = true;
        while (isArrayInputStillGoing){
            System.out.println();
            System.out.println("Въведете колко на брой думи ще въвеждате");
            int sizeOfArray = scanner.nextInt();
            if (sizeOfArray <= 0){
                System.err.println("Броя на числата не може да е по-малък от 1");
                continue;
            }
            array = new String[sizeOfArray+1];
            System.out.println("Въведете думи не по-дълги от 20 символи");
            for(int i=0;i<sizeOfArray+1;i++){
                array[i] = scanner.nextLine();
                if (array[i].length()>20){
                    System.err.println("Опитайте пак с дума не по-дълга от 20 символа");
                    i--;
                }
            }
            isArrayInputStillGoing=false;
        }
        return array;
    }
}