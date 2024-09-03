package pac;
//Write a program to perform Array operation 
import java.util.Scanner;

public class ArraysOperations {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // enter the length/size of the array
        System.out.println("Enter the size of the array:");
        int length = sc.nextInt();

        // Initialize the array with the given size
        int[] array = new int[length];

        // Fill the array with user input
        System.out.println("Enter " + length + " elements:");
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }

        // Calculate the sum of all elements
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
        }

        // Find the maximum value in the array
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // Reverse the array
        int[] reversedArray = new int[length];
        for (int i = 0; i < length; i++) {
            reversedArray[i] = array[length - 1 - i];
        }

        // Display the results
        System.out.println("Sum of all elements: " + sum);
        System.out.println("Maximum value: " + max);
        System.out.print("Reversed array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(reversedArray[i] + " ");
        }

        // Closing the scanner
        sc.close();
    }
}