package com;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {

    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // 1. Add elements to the LinkedList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.addFirst("Mango"); // Add at the beginning
        linkedList.addLast("Grapes"); // Add at the end
        System.out.println("LinkedList after adding elements: " + linkedList);

        // 2. Remove elements from the LinkedList
        linkedList.remove("Banana"); // Remove specific element
        linkedList.removeFirst(); // Remove the first element
        linkedList.removeLast(); // Remove the last element
        System.out.println("LinkedList after removing elements: " + linkedList);

        // 3. Update elements in the LinkedList
        linkedList.set(1, "Orange"); // Update the element at index 1
        System.out.println("LinkedList after updating elements: " + linkedList);

        // 4. Access elements in the LinkedList
        String firstElement = linkedList.getFirst();
        String lastElement = linkedList.getLast();
        String secondElement = linkedList.get(1); // Element at index 1
        System.out.println("First Element: " + firstElement);
        System.out.println("Second Element: " + secondElement);
        System.out.println("Last Element: " + lastElement);

        // 5. Traverse the LinkedList
        System.out.print("Traversing LinkedList: ");
        for (String element : linkedList) {
            System.out.print(element + " ");
        }
        System.out.println();

        // 6. Iterate using ListIterator (forward and backward)
        System.out.print("Traversing forward using ListIterator: ");
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        System.out.print("Traversing backward using ListIterator: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();

        // 7. Check if LinkedList contains an element
        boolean contains = linkedList.contains("Orange");
        System.out.println("LinkedList contains 'Orange': " + contains);

        // 8. Get the size of the LinkedList
        int size = linkedList.size();
        System.out.println("Size of LinkedList: " + size);

        // 9. Clear the LinkedList
        linkedList.clear();
        System.out.println("LinkedList after clearing: " + linkedList);
    }
}
