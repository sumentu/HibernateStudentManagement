package com.te.hibernatedemo.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.hibernatedemo.bean.StudentsDetails;

import net.bytebuddy.implementation.ExceptionMethod;


public class StudentManagementSystem1  {
	public static void main(String[] args) {
		System.out.println("press 1 for all the details");
		System.out.println("press 2 for particular record");
		System.out.println("press 3 for upadate the record");
		System.out.println("press 4 for delete the record");
		boolean check = false;
		while (check = true) {
			Scanner sc = new Scanner(System.in);
			switch (sc.next()) {
			case "1":
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
				EntityManager manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				String findAll = "from StudentDetails";
				Query query = manager.createQuery(findAll);
				List<StudentsDetails> details = query.getResultList();
				for (StudentsDetails student : details) {
					System.out.println(student);
				}
				transaction.commit();
				break;

			case "2":
				Scanner s1 = new Scanner(System.in);
				int rollno1 = s1.nextInt();
				if (5 >= rollno1) {
					try {
						ExceptionMethod.rollNo();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {
					factory = Persistence.createEntityManagerFactory("emp");
					manager = factory.createEntityManager();
					transaction = manager.getTransaction();
					transaction.begin();
					String findAny = "from StudentDetails where rollno=:rollno";
					Query query2 = manager.createQuery(findAny);
					query2.setParameter("rollno", rollno1);
					StudentsDetails studentDetails = (StudentsDetails) query2.getSingleResult();
					System.out.println(studentDetails);
				}

			case "3":
				Scanner s2 = new Scanner(System.in);
				System.out.println("enter the rollno:");
				int rollno2 = s2.nextInt();
				System.out.println("do you want to update by name(y/n):");
				String find = s2.next();
				switch (find) {
				case "y":
					System.out.println("enter the name:");
					String name = s2.next();
					factory = Persistence.createEntityManagerFactory("emp");
					manager = factory.createEntityManager();
					transaction = manager.getTransaction();
					transaction.begin();
					String update = "update from StudentDetails set name=:name where rollno=:rollno";
					Query query3 = manager.createQuery(update);
					query3.setParameter("rollno", rollno2);
					query3.setParameter("name", name);
					int result1 = query3.executeUpdate();
					transaction.commit();

				case "n":
					System.out.println("do you want to update the phno:");
					Scanner s4 = new Scanner(System.in);
					String find2 = s4.next();
					switch (find2) {
					case "y":
						System.out.println("enter the phno:");
						long phno = s4.nextLong();
						factory = Persistence.createEntityManagerFactory("emp");
						manager = factory.createEntityManager();
						transaction = manager.getTransaction();
						transaction.begin();
						String update2 = "update from StudentDetails set phno=:phno where rollno=:rollno";
						Query query4 = manager.createQuery(update2);
						query4.setParameter("rollno", rollno2);
						query4.setParameter("phno", phno);
						int result3 = query4.executeUpdate();
						transaction.commit();

					case "n":
						System.out.println("do you want to update the standard:");
						Scanner s5 = new Scanner(System.in);
						String find3 = s5.next();
						switch (find3) {
						case "y":
							System.out.println("enter the name:");
							String standard = s5.next();
							factory = Persistence.createEntityManagerFactory("emp");
							manager = factory.createEntityManager();
							transaction = manager.getTransaction();
							transaction.begin();
							String update3 = "update from StudentDetails set standard=:standard where rollno=:rollno";
							Query query5 = manager.createQuery(update3);
							query5.setParameter("rollno", rollno2);
							query5.setParameter("standard", standard);
							int result4 = query5.executeUpdate();
							transaction.commit();

						case "n":
							break;
						}

					case "4":
						Scanner s3 = new Scanner(System.in);
						System.out.println("enter the rollno:");
						int rollno3 = s3.nextInt();
						if (5 >= rollno3) {
							try {
								ExceptionMethod.rollNo();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else {
							factory = Persistence.createEntityManagerFactory("emp");
							manager = factory.createEntityManager();
							transaction = manager.getTransaction();
							transaction.begin();
							String delete = "delete from StudentDetails where rollno=:rollno";
							Query query6 = manager.createQuery(delete);
							query6.setParameter("rollno", rollno3);
							int result2 = query6.executeUpdate();
							transaction.commit();
						}
					default:
						break;
					}
				}
			}
		}
	}
}


 


	