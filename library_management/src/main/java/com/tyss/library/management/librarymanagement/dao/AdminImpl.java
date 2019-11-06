package com.tyss.library.management.librarymanagement.dao;

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
public class AdminImpl implements AdminInterface {

	@Override
	public boolean registerUser(UserInfo user, String to, String subject, String body) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		UserInfo userInfo = new UserInfo();
		try {
			et.begin();
			em.persist(userInfo);
			System.out.println("added successfully");
			et.commit();
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteUser(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		UserInfo userInfo = null;
		 try {
       	  et.begin();
       	UserInfo  u = em.find(UserInfo.class, email);
       	if(u==null) {
       		return false;
       	}
       	  em.remove(u);
       	  System.out.println("data deleted.....");
       	  et.commit();
         }catch(Exception e) {
       	  et.rollback(); 
       	  e.printStackTrace();
         }
		return true;
	}

	@Override
	public boolean updateUser(UserInfo user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		UserInfo userInfo = new UserInfo();
		 try {
	       	  et.begin();
	       	UserInfo  u = em.find(UserInfo.class, user.getEmail());
	       	  if(u==null) {
	       		  return false;
	       	  }
	       	  u.setName(user.getName());
	       	  u.setPassword(user.getPassword());
	       	  u.setId(user.getId());
	       	  System.out.println("user updated.....");
	       	  et.commit();
	         }catch(Exception e) {
	       	  et.rollback(); 
	       	  e.printStackTrace();
	         }
		return true;
	}

	

	@Override

	public UserInfo login(String email, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		UserInfo userInfo = null;
		
		String jpaQuery = "from UserInfo where email= :email and password= :pwd";
		Query query = em.createQuery(jpaQuery); //PERSISTANT QUERY
		query.setParameter("email",email);
		query.setParameter("pwd", password);
		try {
			userInfo = (UserInfo)query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public List<BooksInventory> getAllBook() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager=emf.createEntityManager();
		String jpql="From BookInfo";
		Query query=manager.createQuery(jpql);
		List<BooksInventory>books=query.getResultList();
		return books;
		
	}

	@Override
	public List<UserInfo> getAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
		EntityManager manager=emf.createEntityManager();
		String jpql="From UserInfo";
		Query query=manager.createQuery(jpql);
		List<UserInfo>users=query.getResultList();
		return users;
	}

//	@Override
//	public UserInfo searchuser(UserInfo email) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-unit");
//		EntityManager manager=emf.createEntityManager();
//		EntityManager em=emf.createEntityManager();
//		UserInfo ui=em.find(UserInfo.class, email.getName());
//		
//		if(ui==null) {
//			return null;
//		}
//		return ui;
//	}
	
	
}



	

