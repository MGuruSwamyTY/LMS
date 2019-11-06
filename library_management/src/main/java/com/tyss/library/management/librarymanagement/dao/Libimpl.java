package com.tyss.library.management.librarymanagement.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;


@Repository
public class Libimpl implements LibrarianInterface {

	@Override
	public UserInfo login(String email, String password) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		UserInfo userInfo = null;

		String jpaQuery = "from UnserInfo where email = :email and password = :pwd";
		Query query = manager.createQuery(jpaQuery);
		query.setParameter("email", email);
		query.setParameter("pwd", password);
		try {
			userInfo = (UserInfo) query.getSingleResult();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public boolean addBook(BooksInventory booksInventory) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(booksInventory);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}

	}

	@Override
	public boolean deleteBook(int bid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			BooksInventory booksInventory = manager.find(BooksInventory.class, bid);
			if(booksInventory==null) {
				return false;
			}
			manager.remove(booksInventory);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
	}



	@Override
	public List<BooksInventory> getAllBook() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager = factory.createEntityManager();
		String jpql = "from BookInfo";
		Query query = manager.createQuery(jpql);
		List<BooksInventory> booksInventory = query.getResultList();
		return booksInventory;

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<BooksInventory> getIssueBookList(int userId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager em = factory.createEntityManager();
		String jpql="from StudentBookDto where userId=:userId";
		Query query=em.createQuery(jpql);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public boolean updateBook(BooksInventory booksInventory) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		BooksInventory booInfo = manager.find(BooksInventory.class, booksInventory.getBid());
		if(booksInventory == null) {
			return false;
		}
		booksInventory.setBid(booInfo.getBid());
		booksInventory.setAuthor(booInfo.getAuthor());
		booksInventory.setName(booInfo.getName());
		//booInfo.setIssuebook(booksInventory.getIssuebook());
		transaction.commit();
		return true;
	}
	@Override
	public BooksInventory acceptBookRequest(int userId, int bookId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		BooksInventory studentBook=new BooksInventory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			BooksInventory bookInfoDto=em.find(BooksInventory.class,bookId);
			et.begin();
			if(bookInfoDto!=null) {
				Date date = new Date();
				studentBook.setBid(userId);
				studentBook.setBid(bookId);
				studentBook.setName(bookInfoDto.getName());
				studentBook.setAuthor(bookInfoDto.getAuthor());
				//	studentBook.setIssuebook(date);

				em.remove(bookInfoDto);

				em.persist(studentBook);
			}

			et.commit();	
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return studentBook;
	}//End of acceptBookRequest

	@Override
	public boolean fine(UserInfo userfine) {

		return false;
	}

	@Override
	public boolean returnBook(int bookId) {
		boolean flag=false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("library-unit");
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			BooksInventory studentBook=em.find(BooksInventory.class,bookId);
			BooksInventory booksInventory=new BooksInventory();
			if(studentBook!=null) {
				booksInventory.setBid(studentBook.getBid());
				booksInventory.setName(studentBook.getName());
				booksInventory.setAuthor(studentBook.getAuthor());


				et.begin();
				em.remove(studentBook);
				em.persist(booksInventory);
				et.commit();
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}



