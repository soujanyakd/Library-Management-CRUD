package LibraryManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {
	private String fileName;
	Scanner input = new Scanner(System.in);

	private void setFileName() {
		System.out.println("Enter the Name Of The Library (Eg: Science, History, Literature etc) :");
		this.fileName = input.nextLine();
	}

	String getFileName() {
		return fileName;
	}

	private static int displayMainOptions(int numberOfInvalidInputs) {
		Scanner userInput = new Scanner(System.in);
		int userEnteredChoice = 0;
		System.out.println("-------MainMenu------");
		System.out.println("1. Create a Library \n2. Display list of books \n3. Update the Books List "
				+ "\n4. Delete the Library \nEnter 0 to Exit ");
		System.out.println("Enter your Choice: ");
		try {
			userEnteredChoice = userInput.nextInt();
		} catch (InputMismatchException e) {
			if (numberOfInvalidInputs < 2) {
				System.out.println(e + " !!!! Invalid Input !!!");
				System.out.println("Re-Enter your Choice");
				numberOfInvalidInputs++;
				displayMainOptions(numberOfInvalidInputs);
			} else {
				System.out.println("Exited out of main menu!!!!");
				System.out.println("Since you have exceeded the limit by entering incorrect choice.");
				System.exit(0);
			}
		}
		return userEnteredChoice;
	}

	public static void main(String[] args) {
		System.out.println("!!!!!For Admin Use Only!!!!!");
		LibrarySystem librarySystem = new LibrarySystem();
		int userEnteredChoice = 0;
		librarySystem.setFileName();
		if (librarySystem.getFileName() == "") {
			System.out.println("Invalid File name");
		} else {
			do {
				int numberOfInvalidInputs = 0;
				userEnteredChoice = LibrarySystem.displayMainOptions(numberOfInvalidInputs);
				switch (userEnteredChoice) {
				case 0:
					System.out.println("Exited Out of Main Menu");
					break;
				case 1:
					CreateLibrary.createLibrary(librarySystem.getFileName());
					break;
				case 2:
					DisplayListOfBooks.displayListOfBooksFromLibrary(librarySystem.getFileName());
					break;
				case 3:
					UpdateLibrary.updateLibrary(librarySystem.getFileName());
					break;
				case 4:
					DeleteLibrary.deleteLibrary(librarySystem.getFileName());
					break;
				default:
					System.out.println("Invalid Choice!!! Re-Enter your Choice");
					break;
				}
			} while (userEnteredChoice != 0);
		}
	}
}
