package File_Pac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
	
	private File file = null;
	private FileOutputStream outputStream = null;
	private FileInputStream inputStream = null;
	private ObjectInputStream objectInputStream = null ;
	private ObjectOutputStream objectOutputStream = null;
	
	
	public void createFile(){
		file = new File("object.txt");
		try {
			
			if(file.createNewFile())
				System.out.println("File is created\n");
			else
				System.out.print("File already exists\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createObjectFile(){
		ArrayList<String> hobies = new ArrayList<String>();
		hobies.add("Reading Book");
		hobies.add("watching Film");
		hobies.add("Playing Foutball ");
		User  user = new User("Burkay Durdu",781, "Manager", hobies);
		
		try{
		outputStream = new FileOutputStream(file,false);
		objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(user);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	public void readingObjectFile(){	
		try{
			inputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(inputStream);
			User user = (User)objectInputStream.readObject();
			System.out.println(user.getUser());
		} catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
