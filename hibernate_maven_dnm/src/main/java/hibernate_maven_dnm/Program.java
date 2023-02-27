package hibernate_maven_dnm;

import java.util.List;

import javax.persistence.*;

public class Program {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnitName");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		
		Query query = manager.createQuery("SELECT s FROM Student s WHERE name= :name"); //JPQL
		query.setParameter("name", "bing");
		List<Student> list = query.getResultList();
		
		for (Student student : list) {
			System.out.printf("%d %s %s \n", student.getId(), student.getName(), student.getLastName());
		}

		//Student student = new Student("Chandler", "Bing");
		
		//Student student = manager.find(Student.class, 1);
		//student.setName("Ross");

		//transaction.begin();
		
		//manager.merge(student); //update
		//manager.persist(student); //insert
		//manager.remove(student); //delete

		//transaction.commit();// Bu satýr çalýþana kadar tabloda bir deðiþiklik olmaz.
		
		manager.close();
	}

}
