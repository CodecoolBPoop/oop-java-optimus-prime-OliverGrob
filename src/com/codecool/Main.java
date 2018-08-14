package com.codecool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculatePrimes(1000));
    }

    public static List calculatePrimes(int indexTo) {
        if (indexTo < 2) {
            System.out.println("Wrong input parameter!");
            return null;
        }

        // ----------   ArrayList   ----------
        // Using ArrayList with Boolean values in it, if the valus is false, that number(index) is out
        List<Boolean> numbers = new ArrayList<>(indexTo);

        // Generating array with boolean values
        for (int i = 0; i < indexTo; i++) {
            numbers.add(true);
        }

        // Result array
        List<Integer> result = new ArrayList<>();
        // Start index(indexes 0 and 1 does not play since their values would be 0 and 1)
        int startIndex = 2;

        // Main loop
        while (true) {
            // Looking for the next prime number (true value)
            while (!numbers.get(startIndex)) {
                // If we are at the last index and it still isn't true, we are done
                if (startIndex == indexTo - 1) return result;
                startIndex++;
            }

            // Adding the number to the result array
            result.add(startIndex);

            // Changing the values to false, where needed
            for (int i = startIndex * 2; i < numbers.size(); i += startIndex) {
                numbers.set(i, false);
            }

            // If we are at the last index and it still isn't true, we are done
            if (startIndex == indexTo - 1) return result;
            startIndex++;

        }

        // ----------   LinkedList   ----------
//        List<Integer> numbers = new LinkedList<>();
//
//        for (int i = 2; i < indexTo; i++) {
//            numbers.add(i);
//        }
//
//        ListIterator<Integer> listIterator = numbers.listIterator();
//        List<Integer> result = new LinkedList<>();
//
//        while (listIterator.hasNext()) {
//            int value = listIterator.next();
//            result.add(value);
//            listIterator.remove();
//            while (listIterator.hasNext()) {
//                for (int i = 0; i < value; i++) {
//                    if (!listIterator.hasNext()) break;
//                    listIterator.next();
//                }
//                listIterator.remove();
//            }
//            listIterator = numbers.listIterator();
//        }
//
//        return result;
    }

}
