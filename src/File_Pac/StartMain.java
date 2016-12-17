package File_Pac;

import java.util.ArrayList;

public class StartMain {

	public static void main(String[] args) {
		
		FileManager manage = new FileManager();
		manage.createFile();
		char [] data = {'B','U','R','K','A','Y','D','U','R','D','U'};
		String data_L1="bu bir deneme yazisidir";
		
		ArrayList<String> hobies = new ArrayList<String>();
		hobies.add("Reading Book");
		hobies.add("watching Film");
		hobies.add("Playing Foutball ");
		User  user = new User("Burkay Durdu",781, "Manager", hobies);
		
		
		manage.writingOfObjectFile(hobies,user);
		System.out.println( manage.readingOfObjectFile());
		
		manage.writingOfByteFile(data);
		System.out.println(manage.readingOfByteFile());
		
		manage.writingOfCharacterFile(data);
		System.out.println(manage.readingOfCharacterFile());
		manage.writingOfStringFile(data_L1);
		System.out.println( manage.readingOfStringFile());
	}
}
