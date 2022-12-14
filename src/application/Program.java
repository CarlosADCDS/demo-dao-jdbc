package application;

import java.text.ParseException;

import model.entities.Department;

public class Program {

	public static void main(String[] args) throws ParseException {

		Department obj = new Department(1, "Books");
		
		System.out.println(obj);
		
	}

}
