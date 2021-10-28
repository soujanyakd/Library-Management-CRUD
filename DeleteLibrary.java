package LibraryManagement;

import java.io.File;

public class DeleteLibrary {
	public static void deleteLibrary(String fileName) {
		File file = new File(fileName);
		try {
			if (file.delete()) {
				System.out.println(file.getName() + " Library is deleted");
			} else {
				System.out.println("Library doesn't exist");
			}
		} catch (Exception e) {
			System.out.println("An error occured while deleting the Library!!!!");
		}
	}
}
