package com;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListUserInput {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLinkedList Operations Menu:");
            System.out.println("1. Add Element");
            System.out.println("2. Remove Element");
            System.out.println("3. Update Element");
            System.out.println("4. Display Elements");
            System.out.println("5. Check if Element Exists");
            System.out.println("6. Get Size of LinkedList");
            System.out.println("7. Clear LinkedList");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:  // Add Element
                    System.out.print("Enter element to add: ");
                    String elementToAdd = scanner.nextLine();
                    System.out.println("Where to add?");
                    System.out.println("1. Add to the beginning");
                    System.out.println("2. Add to the end");
                    int addChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (addChoice == 1) {
                        linkedList.addFirst(elementToAdd);
                    } else {
                        linkedList.addLast(elementToAdd);
                    }
                    System.out.println("Element added.");
                    break;

                case 2:  // Remove Element
                    System.out.print("Enter element to remove: ");
                    String elementToRemove = scanner.nextLine();
                    if (linkedList.remove(elementToRemove)) {
                        System.out.println("Element removed.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 3:  // Update Element
                    System.out.print("Enter element to update: ");
                    String elementToUpdate = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();
                    if (linkedList.contains(elementToUpdate)) {
                        linkedList.set(linkedList.indexOf(elementToUpdate), newValue);
                        System.out.println("Element updated.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 4:  // Display Elements
                    System.out.println("LinkedList elements:");
                    if (linkedList.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        for (String item : linkedList) {
                            System.out.print(item + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 5:  // Check if Element Exists
                    System.out.print("Enter element to check: ");
                    String elementToCheck = scanner.nextLine();
                    if (linkedList.contains(elementToCheck)) {
                        System.out.println("Element exists in the list.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 6:  // Get Size of LinkedList
                    System.out.println("Size of LinkedList: " + linkedList.size());
                    break;

                case 7:  // Clear LinkedList
                    linkedList.clear();
                    System.out.println("LinkedList cleared.");
                    break;

                case 8:  // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
