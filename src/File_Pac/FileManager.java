package File_Pac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
	private FileReader fileReader = null;
	private FileWriter fileWriter = null;
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	
	
	public void createFile(){
		file = new File("object.txt");
		try {
			
			if(file.createNewFile())
				System.out.println("File is created\n");
			else
				System.out.print("File already exists\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writingOfObjectFile(ArrayList<String>hobies ,User user){
		
		try{
		outputStream = new FileOutputStream(file,false);
		objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(user);
		objectOutputStream.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	public String readingOfObjectFile(){
		
		try{
			inputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(inputStream);
			User user = (User)objectInputStream.readObject();
			inputStream.close();
			return user.getUser();
		} catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}
	}
	public void  writingOfByteFile(char[] Data){
		try {
			outputStream = new FileOutputStream(file);
			for(char dat : Data)
				outputStream.write(dat);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String readingOfByteFile(){
		try {
			inputStream= new FileInputStream(file);
			byte dat;
			String data="";
			while((dat=(byte)inputStream.read())!=-1){
				data+=(char)dat;
			}
			inputStream.close();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void writingOfCharacterFile(char [] dat){
		
		try {
			fileWriter = new FileWriter(file);
			for(char character : dat)
					fileWriter.write(character);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String readingOfCharacterFile(){
		int character;
		String data="";
		try {
			fileReader = new FileReader(file);	
			while((character = (int) fileReader.read())!=-1)
					data+=(char)character;
			fileReader.close();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void writingOfStringFile(String Data){
		
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(Data);
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String readingOfStringFile(){
		StringBuilder data = new StringBuilder();
		String dat;	
		try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				while((dat = bufferedReader.readLine())!=null)
					data.append(dat);
				bufferedReader.close();
				fileReader.close();
				return data.toString();
			} catch (IOException e) {
					e.printStackTrace();
					return null;
			}
	}
}
