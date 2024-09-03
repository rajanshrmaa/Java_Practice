//

package pac;

import java.util.Scanner;

public class ExceptionHandling {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
	// Using  try and catch
		try {
			System.out.println("Enter (1 or 2) to choose exception type");
			System.out.println("Enter 1 for Arithmetic exeption (Division by zero) ");
			System.out.println("Enter 2 for ArrayIndexOutOfBoundException (Invalud array index");
			int choice = sc.nextInt();
			
			// Switch for particular case
			switch (choice){
				case 1:
					// Arithmetic exception
					
					System.out.println("Enter a number to divide 100 by :");
					int divisor = sc.nextInt();
					
					System.out.println("Result: "+(100 / divisor));
					
					break;
					
				case 2:
					// ArrayIndexOutOfBound exception
					
					System.out.println("Enter the size/length of the array");
					int length;
					length = sc.nextInt();
					
					int[] arr = new int[length];
					System.out.println("Enter the value to array");
					for(int i=0;i<=length;i++){
						arr[i] = sc.nextInt();
					}
					
					for (int i = 0; i< length; i++)
					{
					System.out.println("Element at index " +i+ ":" +arr[i]);
			}
					//Initializing array with given size
					System.out.println(arr);
					System.out.println("Enter an array index (0 to 4) to access :");
					int index = sc.nextInt();
					
					System.out.println("Array value at index "+ index +": "+ arr[index]);
					
					break;
					
					default:
						
						System.out.println("Invalid choice enter only 1 or 2");
							
			}
		}
		// catch blocks for exception handling
			catch(ArithmeticException e) {
				
				System.out.println("Caught ArithmeticException: " + e.getMessage());
			
			}
		catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Cought ArrayIndexOutOfBoundsException: " +e.getMessage());
		}
		finally {
			sc.close();
			System.out.println("Exception Completed");
		}
		
	}
			
}
