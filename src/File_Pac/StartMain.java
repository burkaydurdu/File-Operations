package File_Pac;

public class StartMain {

	public static void main(String[] args) {
		FileManager manage = new FileManager();
		manage.createFile();
		//manage.createObjectFile();
		manage.readingObjectFile();
	}
}
