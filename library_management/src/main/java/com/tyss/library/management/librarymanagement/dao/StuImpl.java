package com.tyss.library.management.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.library.management.librarymanagement.dto.BooksInventory;
import com.tyss.library.management.librarymanagement.dto.UserInfo;
@Repository
public class StuImpl implements StudentInterface {
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public UserInfo login(String email, String password) {
		EntityManager em=emf.createEntityManager();
		UserInfo userinfo = null;
		String jpaQuery ="from UserInfo where email=:email and password=:pwd";
		Query query=em.createQuery(jpaQuery);
		query.setParameter("email",email);
		query.setParameter("pwd",password);
		try {
			 userinfo=(UserInfo) query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userinfo;
	}

	@Override
	public List<BooksInventory> getAllBook() {
		EntityManager em=emf.createEntityManager();
		String jpql = "from BookInfo";
		Query query = em.createQuery(jpql);
		List<BooksInventory> booksInventory = query.getResultList();
		return booksInventory;	
	}

	@Override
	public BooksInventory sendRequest(String bname) {

		return null;
	}


//	@Override
//	public BooksInventory searchBook(BooksInventory name) {
//		EntityManager em=emf.createEntityManager();
//		BooksInventory bi=em.find(BooksInventory.class,name.getName());
//		if(bi==null) {
//			return null;
//		}
//		return bi;
//	}

	@Override
	public UserInfo changepassword(String email, String password, String newpassword) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		String jpql="from UserInfo where email=:email and password=:password";
		try {
			Query query=em.createQuery(jpql);
			query.setParameter("password",password);
			UserInfo	userinfo=(UserInfo)query.getSingleResult();
			if(userinfo!=null) {
				userinfo.setPassword(newpassword);
				et.commit();
				return userinfo;
			}
			else { return null;}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
