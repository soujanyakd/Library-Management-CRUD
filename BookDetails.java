package LibraryManagement;

import java.util.Hashtable;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;

public class BookDetails {
	Hashtable<String, String> booksList = new Hashtable<String, String>();
	Scanner userInputForNumberOfBooks = new Scanner(System.in);
	Scanner userInputForBooksDetails = new Scanner(System.in);
	Scanner userInput = new Scanner(System.in);

	String nameOfTheBook;
	String idOfTheBook;

	private String bookName(int indexOfBook) {
		System.out.println("Enter Book-Name of book " + indexOfBook);
		this.nameOfTheBook = userInputForBooksDetails.nextLine();
		return nameOfTheBook.toUpperCase();
	}
	
	private static String generateAlphaNumericId() {
		String generatedAlphabeticString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumericString = RandomStringUtils.randomNumeric(3);
	    String generatedAlphaNumericBookId = (generatedAlphabeticString.toUpperCase() + generatedNumericString);
	    return generatedAlphaNumericBookId.toString();
	}

	public Hashtable<String, String> writeBookDetails() {
		int numberOfBooksIntoTheLibrary = 0;
		try {
			System.out.println("Enter the number of books you want to add into the Library");
			numberOfBooksIntoTheLibrary = userInputForNumberOfBooks.nextInt();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Invalid Input , Please try again Later.");
		}
		int numberOfInvalidInputs = 0;
		if (numberOfBooksIntoTheLibrary <= 10) {
			for (int bookIndex = 1; bookIndex <= numberOfBooksIntoTheLibrary; bookIndex++) {
				if (numberOfInvalidInputs <= 2) {
					String bookId = BookDetails.generateAlphaNumericId();
					String bookName = bookName(bookIndex);
					if (bookName != null) {
						booksList.put(bookId, bookName);
					} else {
						System.out.println("Invalid BookName");
						System.out.println("Please Re-Enter the Details");
						numberOfInvalidInputs++;
						bookIndex--;
					}
				} else {
					System.out.println("Please try again later!!");
					System.exit(0);
				}
			}
		} else {
			System.out.println("You can only enter 10 or less than 10 books at a time");
		}
		return booksList;
	}
}
