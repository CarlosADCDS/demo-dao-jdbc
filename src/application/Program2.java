package application;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) throws ParseException {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Para buscar por id, digite 1.\n" + "Para buscar todos, digite 2.\n" + "Para inserir, digite 3.\n"
						+ "Para realizar um update, digite 4.\n" + "Para deletar por id, digite 5.");
		int opcao = sc.nextInt();

		if (opcao != 5) {
			sc.close();
		}

		switch (opcao) {
		case 1: {
			System.out.println("=== TEST 1: department findByID ===");
			Department department = departmentDao.findById(3);
			System.out.println(department);
			break;
		}
		case 2: {
			System.out.println("\n=== TEST 2: department findAll ===");
			List<Department> list = departmentDao.findAll();
			for (Department obj : list) {
				System.out.println(obj);
			}
			break;
		}
		
		case 3: {
			System.out.println("\n=== TEST 3: department insert ===");
			Department department = new Department(null, "Jogos");
			departmentDao.insert(department);
			System.out.println("Inserted! New id = " + department.getId());
			break;
		}		
		case 4: {
			System.out.println("\n=== TEST 4: department update ===");
			Department department = null;
			department = departmentDao.findById(5);
			department.setName("Games");
			departmentDao.update(department);
			System.out.println("Update completed");
			break;
		}
		case 5: {
			System.out.println("\n=== TEST 6: department deleteById ===");
			System.out.println("Enter id for deletion: ");
			int id = sc.nextInt();
			departmentDao.deleteById(id);
			System.out.println("Deletion completed");
			sc.close();
			break;
		}		
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao);
		}
	}

}
