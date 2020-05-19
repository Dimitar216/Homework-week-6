package uni.informatics;

import java.util.Random;
import java.util.Scanner;

public class Sort {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numberArray = new int[1];
        String[] stringArray = new String[1];
        Random random = new Random();
        int limit = 1000;
        int sum = random.nextInt(limit);
        initialMenuSelector(numberArray,stringArray,sum);
    }

    public static void initialMenuRender() {
        System.out.println("Главно меню с опции:");
        System.out.println("1. Работа с числа");
        System.out.println("2. Работа с думи");
        System.out.println("3. Изход от програмата");
    }

    public static void initialMenuSelector(int[] numberArray,String[] stringArray,int sum) {
        initialMenuRender();
        System.out.println();
        System.out.print("Изберете опция: ");
        int selector = scanner.nextInt();
        switch (selector) {
            case 3:
                System.out.println();
                System.out.println("Изход от програмата");
                System.exit(0);
                break;
            case 2:
                System.out.println();
                System.out.println("Работа с думи");
                String[] secondStringArray = ArrayInput.arrayStringCreation(stringArray);
                arrayStringRender(secondStringArray);
                wordMenuSelector(numberArray,secondStringArray,sum);
                break;
            case 1:
                System.out.println();
                System.out.println("Работа с числа");
                int[] secondArray = ArrayInput.arrayNumberCreation(numberArray);
                arrayNumberRender(secondArray);
                numberMenuSelector(secondArray,stringArray,sum);
                break;
            default:
                System.out.println();
                System.out.println("Невалиден избор");
                initialMenuSelector(numberArray,stringArray,sum);
        }
    }

    public static void arrayNumberRender(int[] array) {
        for (int i : array) {
            System.out.print(i + " , ");
        }
    }

    public static void arrayStringRender(String[] array){
        for(String str:array){
            System.out.println(str);
        }
    }

    public static void numberMenuRender() {
        System.out.println("Меню с опции:");
        System.out.println("1. Извеждане само на простите числа от масива");
        System.out.println("2. Извеждане на най-често срещан елемент в масива ");
        System.out.println("3. Извеждане на максимална редица от нарастващи елементи в масива");
        System.out.println("4. Извеждане на максимална редица от намаляващи елементи в масива ");
        System.out.println("5. Извеждане на максимална редица от еднакви елементи в масива ");
        System.out.println("6. Извеждане на последователност от числа от масива, които имат сума равна на число, генерирано на случаен принцип ");
        System.out.println("7. Връщане назад към основното меню");
    }

    public static void numberMenuSelector(int[] array,String[] stringArray,int sum) {
        System.out.println();
        numberMenuRender();
        int select = scanner.nextInt();
        switch (select) {
            case 5:
                printLongestRepeatingSubArray(array);
                numberMenuSelector(array,stringArray,sum);
                break;
            case 4:
                printLongestDecreasingSubArray(array);
                numberMenuSelector(array,stringArray,sum);
                break;
            case 3:
                printLongestIncreasingSubArray(array);
                numberMenuSelector(array,stringArray,sum);
                break;
            case 6:
                randomNumberSumCalculator(array,sum);
                break;
            case 2:
                System.out.println();
                System.out.println("Най-често срещаният елемент е "+getPopularElement(array));
                numberMenuSelector(array,stringArray,sum);
                break;
            case 7:
                initialMenuSelector(array,stringArray,sum);
                break;
            case 1:
                primePrintFunction(array);
                numberMenuSelector(array,stringArray,sum);
                break;
            default:
                System.out.println();
                System.out.println("Невалиден избор");
                numberMenuSelector(array,stringArray,sum);
        }
    }

    public static void primePrintFunction(int[] array) {
        for(int i=0; i<array.length; i++){
            boolean isPrime = true;
            for (int j=2; j<array[i]; j++){

                if(array[i]%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)

                System.out.println(array[i] + " е просто число на индекс "+i);
        }
    }

    public static int getPopularElement(int[] array) {
        int count = 1, tempCount;
        int popular = array[0];
        int temp = 0;
        for (int i = 0; i < (array.length - 1); i++)
        {
            temp = array[i];
            tempCount = 0;
            for (int j = 1; j < array.length; j++)
            {
                if (temp == array[j])
                    tempCount++;
            }
            if (tempCount > count)
            {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }

    public static void wordMenuRender(){
        System.out.println("Меню с опции:");
        System.out.println("1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата");
        System.out.println("2. Изведете броя на повтарящите се символи за всяка една от думите в масива");
        System.out.println("3. Изведете броя на символите за всяка една от думите в масива");
        System.out.println("4. Изведете броя на повтарящите се думи от масива");
        System.out.println("5. Връщане назад към основното меню");
    }

    public static void wordMenuSelector(int[] numberArray,String[] array,int sum){
        System.out.println();
        wordMenuRender();
        int select = scanner.nextInt();
        switch(select){
            case 4:
                String[] q = array;
                totalWordCounter(array,q);
            case 5:
                initialMenuSelector(numberArray,array,sum);
            case 3:
                totalCharacterCounter(array);
                wordMenuSelector(numberArray,array,sum);
            case 2:
                charCounter(array);
                wordMenuSelector(numberArray,array,sum);
            case 1:
                reverse(array);
                wordMenuSelector(numberArray,array,sum);
            default:
                System.out.println();
                System.err.println("Невалиден избор");
                wordMenuSelector(numberArray,array,sum);
        }
    }

    public static void reverse(String[] array) {
        String reverse;
        for (int i = 0; i < array.length; i++) {
            reverse = "";
            for (int j = array[i].length() - 1; j >= 0; j--) {
                reverse += array[i].charAt(j);
            }
            array[i] = reverse;
        }
        arrayStringRender(array);
    }

    public static void charCounter(String[] array){
        for(int i=0;i<array.length;i++){
            characterCountFunction(array[i]);
        }
    }

    public static void characterCountFunction(String inputString) {
        int occurrenceCounter = 0 ;

        for (int i = 0; i < inputString.length(); i++) {

            for (int j = 0; j < inputString.length(); j++) {

                if(inputString.charAt(i)==inputString.charAt(j))
                {
                    occurrenceCounter++;

                }
            }
            System.out.println(inputString);
            System.out.println(inputString.charAt(i)+" - "+occurrenceCounter+" ");
            String d=String.valueOf(inputString.charAt(i)).trim();
            inputString=inputString.replaceAll(d,"");
            occurrenceCounter = 0;

        }
    }

    public static void totalCharacterCounter(String[] array){
        for(int i=0;i<array.length;i++){
            totalCharacterCounterFunction(array[i]);
        }
    }

    public static void totalCharacterCounterFunction(String array){
        int count = 0;
            for (int i = 0; i < array.length(); i++) {
                if (array.charAt(i) != ' ')
                    count++;
            }
        System.out.println(array+" има общо " + count+" символа");
    }

    public static void randomNumberSumCalculator(int[] array, int sum){
        System.out.println("Случайно генерирано число: " + sum);
        System.out.println("Числа чийто сбор е равен на : " + sum);
        randomNumberSumCalculatorFunction(array,sum);
    }

    public static void randomNumberSumCalculatorFunction(int[] array,int sum){
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];

                if ((first + second) == sum) {
                    System.out.printf("(%d, %d) %n", first, second);
                } else{
                    System.out.println("Няма такива числа");
                }
            }

        }

    }

    public static int totalWordCounterFunction(String[] array, String string){
        int counter = 0;
        for (int j = 0; j < array.length; j++)

            if (string.toLowerCase().equals(array[j].toLowerCase()))
                counter++;

        return counter;
    }

    public static void totalWordCounter(String[] array,String[] secondArray){
        for (int i=0;i<array.length; i++)
            System.out.println(array[i]+" Is found " +totalWordCounterFunction(array, secondArray[i]) + " times ");
    }

    public static void printLongestIncreasingSubArray(int[] array) {
        int max = 1, len = 1, maxIndex = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] > array[i-1])
                len++;
            else
            {
                if (max < len)
                {
                    max = len;

                    maxIndex = i - max;
                }

                len = 1;
            }
        }

        if (max < len)
        {
            max = len;
            maxIndex = array.length - max;
        }
        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(array[i] + " ");
    }

    public static void printLongestDecreasingSubArray(int[] array) {
        int max = 1, len = 1, maxIndex = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] < array[i-1])
                len++;
            else
            {
                if (max < len)
                {
                    max = len;

                    maxIndex = i - max;
                }

                len = 1;
            }
        }

        if (max < len)
        {
            max = len;
            maxIndex = array.length - max;
        }
        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(array[i] + " ");
    }

    public static void printLongestRepeatingSubArray(int[] array){
        int max = 1, len = 1, maxIndex = 0;

        for (int i = 1; i < array.length; i++) {

            if (array[i] == array[i-1])
                len++;
            else
            {
                if (max < len)
                {
                    max = len;

                    maxIndex = i - max;
                }

                len = 1;
            }
        }

        if (max < len)
        {
            max = len;
            maxIndex = array.length - max;
        }
        for (int i = maxIndex; i < max+maxIndex; i++)
            System.out.print(array[i] + " ");
    }

}