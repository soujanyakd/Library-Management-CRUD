package LibraryManagement;

import java.io.File;
import java.util.Scanner;

public class DisplayListOfBooks {
	public static void displayListOfBooksFromLibrary(String fileName) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				System.out.println("Library Doesn't Exists!!!!");
			} else {
				if (file.length() == 0) {
					System.out.println(file.getName() + " Library is Empty");
					System.out.println("If you want to enter the Books into the library please use Update Option");
				} else {
					Scanner toReadTheFile = new Scanner(file);
					while (toReadTheFile.hasNextLine()) {
						System.out.println(toReadTheFile.nextLine());
					}
					toReadTheFile.close();
				}
			}
		} catch (Exception e) {
			System.out.println("Error while Fetching the list of books from the Library!!!!");
		}
	}
}
