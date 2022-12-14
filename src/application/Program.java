package application;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		Scanner sc = new Scanner(System.in);

		System.out.println("Para buscar por id, digite 1.\n"
				+ "Para buscar por departamento, digite 2.\n"
				+ "Para buscar todos, digite 3.\n"
				+ "Para inserir, digite 4.\n"
				+ "Para realizar um update, digite 5.\n"
				+ "Para deletar por id, digite 6.");
		int opcao = sc.nextInt();
		
		if(opcao != 6) {
			sc.close();
		}
		
		switch (opcao) {
		case 1: {
			System.out.println("=== TEST 1: seller findByID ===");
			Seller seller = sellerDao.findById(3);
			System.out.println(seller);
			break;
		}
		case 2: {
			System.out.println("\n=== TEST 2: seller findByDepartment ===");
			Department department = new Department(2, null);
			List<Seller> list = sellerDao.findByDepartment(department);
			for (Seller obj : list) {
				System.out.println(obj);
			}
			break;
		}
		case 3: {
			System.out.println("\n=== TEST 3: seller findAll ===");
			List<Seller> list = sellerDao.findAll();
			for (Seller obj : list) {
				System.out.println(obj);
			}
			break;
		}
		case 4: {
			System.out.println("\n=== TEST 4: seller insert ===");
			Department department = new Department(2, null);
			Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
			sellerDao.insert(newSeller);
			System.out.println("Inserted! New id = " + newSeller.getId());
			break;
		}
		case 5: {
			System.out.println("\n=== TEST 5: seller update ===");
			Seller seller = null;
			seller = sellerDao.findById(1);
			seller.setName("Martha Waine");
			sellerDao.update(seller);
			System.out.println("Update completed");
			break;
		}	
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcao);
		}		
	}

}
