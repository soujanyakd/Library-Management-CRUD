package LibraryManagement;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateLibrary {

	private static int displayUpdateOptions(int numberOfInvalidChoices) {
		Scanner userInput = new Scanner(System.in);
		int userEnteredChoice = 0;
		System.out.println("-------Update Option------");
		System.out.println("1. Add Book into the Library \n2. Delete Book from the Library \nEnter 0 to Exist ");
		System.out.println("Enter your Choice: ");
		try {
			userEnteredChoice = userInput.nextInt();
		} catch (InputMismatchException e) {
			if (numberOfInvalidChoices < 2) {
				System.out.println(e + " !!!! Invalid Input !!!");
				System.out.println("Re-Enter your Choice");
				numberOfInvalidChoices++;
				displayUpdateOptions(numberOfInvalidChoices);
			} else {
				System.out.println("Exited out of update option!!!!!");
				System.out.println("Since you exceeded the limit by entering incorrect choice.");
				System.exit(0);
			}
		}
		return userEnteredChoice;
	}

	public static void updateLibrary(String fileName) {
		UpdateBooksList updateBook = new UpdateBooksList();
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File doesn't exist");
		} else {
			int userEnteredChoice = 0;
			do {
				int numberOfInvalidChoices = 0;
				userEnteredChoice = displayUpdateOptions(numberOfInvalidChoices);
				switch (userEnteredChoice) {
				case 1:
					updateBook.addBook(fileName);
					break;
				case 2:
					updateBook.deleteBook(fileName);
					break;
				case 0:
					System.out.println("Exited out of Update option");
					break;
				default:
					System.out.println("Invalid Choice!!! Re-Enter your Choice");
					break;
				}
			} while (userEnteredChoice != 0);
		}
	}
}
