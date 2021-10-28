package LibraryManagement;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;;

public class CreateLibrary {

	public static void createLibrary(String fileName) {
		try {
			File file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println(file.getName() + " Library is Created Successfully.");
				BookDetails bookDetails = new BookDetails();
				WriteBooksList writeBook = new WriteBooksList();
				Hashtable<String, String> contentOfBook = new Hashtable<String, String>();
				contentOfBook = bookDetails.writeBookDetails();
				writeBook.writeIntoLibrary(fileName, contentOfBook);
			} else {
				System.out.println(file.getName() + " Library already exists");
				System.out.println("If you want to enter the Books into the Library, please use Update Option.");
			}
		} catch (IOException e) {
			System.out.println("An Error occured while creating a Library");
		}
	}
}
