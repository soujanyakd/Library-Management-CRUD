package LibraryManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class UpdateBooksList {

	private Map<String, String> convertBook(String fileName) {
		Hashtable<String, String> contentOfBook = new Hashtable<String, String>();
		File file = new File(fileName);
		String eachLineFromListOfBooks;
		try {
			if (!file.exists()) {
				System.out.println("Library Doesn't Exists!!!!");
			} else {
				BufferedReader bufferRead = new BufferedReader(new FileReader(file));
				while ((eachLineFromListOfBooks = bufferRead.readLine()) != null) {
					String[] parts = eachLineFromListOfBooks.split(" : ");
					String bookId = parts[0].trim();
					String bookName = parts[1].trim();
					if (!bookId.equals("") && !bookName.equals("")) {
						contentOfBook.put(bookId, bookName);
					}
				}
				bufferRead.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentOfBook;
	}

	public void addBook(String fileName) {
		WriteBooksList writeBook = new WriteBooksList();
		Hashtable<String, String> existingContent = new Hashtable<String, String>();
		Hashtable<String, String> addContent = new Hashtable<String, String>();
		UpdateBooksList updateBook = new UpdateBooksList();
		BookDetails bookDetails = new BookDetails();
		existingContent = (Hashtable<String, String>) updateBook.convertBook(fileName);
		addContent = bookDetails.writeBookDetails();
		if (!addContent.isEmpty()) {
			for (Object bookIdOfAddContent : addContent.keySet()) {
				if (existingContent.containsValue(addContent.get(bookIdOfAddContent))) {
					System.out.println(addContent.get(bookIdOfAddContent) + " Already exists in this library, Hence Cannot be added");
				} else {
					existingContent.put((String) bookIdOfAddContent, addContent.get(bookIdOfAddContent));
					System.out.println(addContent.get(bookIdOfAddContent) + " Entered into the library.");
					writeBook.writeIntoLibrary(fileName, existingContent);
				}
			}
			
		} else {
			System.out.println("No Books Entered into the Library");
		}
	}

	public void deleteBook(String fileName) {
		Scanner userInput = new Scanner(System.in);
		WriteBooksList writeBook = new WriteBooksList();
		UpdateBooksList updateBook = new UpdateBooksList();
		System.out.println("Enter the BookId of the Book which you want to Delete ");
		String bookId = userInput.nextLine();
		Hashtable<String, String> updatedContent = new Hashtable<String, String>();
		updatedContent = (Hashtable<String, String>) updateBook.convertBook(fileName);
		if (updatedContent.containsKey(bookId)) {
			System.out.println(updatedContent.get(bookId) + " Deleted from the Library.");
			updatedContent.remove(bookId);
			writeBook.writeIntoLibrary(fileName, updatedContent);
		} else {
			System.out.println("Book Doesn't exist");
		}
	}
}
