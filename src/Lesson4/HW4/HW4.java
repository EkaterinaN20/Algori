package Lesson4.HW4;

import Lesson4.LinkedList;
import Lesson4.SimpleLinkedListImpl;

import java.util.Iterator;

public class HW4 {

    public static void main(String[] args) {

        LinkedList<Integer> list = new SimpleLinkedListImpl<>();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);

        displayAll(list);
        System.out.println("_____");

        ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();

        iterator.reset();
        iterator.insertAfter(11);
        iterator.next();
        iterator.remove();
        iterator.insertBefore(0);

        iterator = (ListIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            displayAll(list);
            System.out.println("_____");
        }
    }

        private static void displayAll(LinkedList<Integer> list) {
        for (Integer value: list) {
            System.out.println(value);
            }
        }
    }

