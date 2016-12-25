package File_Pac;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private String userName;
	private int personalNumber;
	private String rank;
	private ArrayList<String> hobis;
	
	public User(String userName , int personalNumber , String rank , ArrayList<String> hobis){
		this.userName = userName;
		this.personalNumber = personalNumber;
		this.rank = rank;
		this.hobis = hobis;
	}
	
	public String getUser(){
		return String.format("User name : %s\n"
										+ "Personal Number : %d\n"
										+"Rank : %s\n"
										+ "Hobies: %s\n",this.userName,this.personalNumber,this.rank,this.hobis.toString());	
	}
}
