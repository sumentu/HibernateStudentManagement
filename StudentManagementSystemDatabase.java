package com.te.hibernatedemo.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.jdbc.Statement;
import com.te.hibernatedemo.bean.Employee;

public class StudentManagementSystemDatabase {
	public static void main(String[] args) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();

			Scanner sc= new Scanner(System.in);
			int str=sc.nextInt();
			System.out.println("------Enter the Operations You want to Perform-----");
			System.out.println("----Press 1 To see all the data----"+str);
			System.out.println("----Press 2 To see all the data----"+str);
			System.out.println("----Press 3 To Update any particular data----"+str);
			System.out.println("----Press 4 To Delete any particular data----"+str);
			
            sc.close();
            
			switch (str){
			case 1:
				//	To see all data
				String findAll="from Student_Table";
				Query query = manager.createQuery(findAll);
				List<Statement>list = query.getResultList();
				System.out.println(list);
				System.out.println("----------------");
				for (Statement student : list) {
					System.out.println(student);
				}
				break;
			case 2:
				//	To see any particular data
				try {
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter Id:");
					int id= scanner.nextInt();
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3: 
				//	To update any particular data
				try {
					Scanner scanner = new Scanner(System.in);

					System.out.println("Enter the Id You wish to Update :");
					int id= scanner.nextInt();
					System.out.println("Enter the name:");
					String name = scanner.next();
					System.out.println("Enter the address:");
					String designation = scanner.next();
					scanner.close();

					String update ="update Employee set name= :name, designation= :designation where id =:id";
					Query query1 = manager.createQuery(update);
					query1.setParameter("name", args[1]);
					query1.setParameter("id", Integer.parseInt(args[0]));
					query1.setParameter("designation",args[2]);
					int result = query1.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				//	To delete the data
				try {
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter the Id You Wish to Delete :");
					int id= scanner.nextInt();
					System.out.println("Enter the name:");
					String name = scanner.next();
					System.out.println("Enter the designation:");
					String designation = scanner.next();
					scanner.close();

					String delete ="delete Employee set name= :name,designation= :designation where id= :id";
					Query query1 = manager.createQuery(delete);
					query1.setParameter("name", args[1]);
					query1.setParameter("id",Integer.parseInt(args[0]));
					query1.setParameter("designation",args[2]);
					transaction.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
