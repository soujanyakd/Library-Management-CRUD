package LibraryManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class WriteBooksList {

	public void writeIntoLibrary(String fileName, Hashtable<String, String> listOfBooks) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				System.out.println("Library Doesn't Exists!!!!");
			} else {
				BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));
				if (!listOfBooks.isEmpty()) {
					for (Object eachBookInList : listOfBooks.keySet()) {
						bufferWriter.write(eachBookInList + " : " + listOfBooks.get(eachBookInList) + "\n");
					}
					System.out.println("Successfully updated the Books in the " + file.getName() + " Library.");
					bufferWriter.close();
				} else {
					System.out.println("No Books Entered into the Library");
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred. Cannot enter Books into a Library");
		}
	}
}
