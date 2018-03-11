package com.exam.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.dao.AdminDao;
import com.exam.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Admin> validateLoginAdmin(String adminEmail, String password) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Admin where adminEmail=:adminEmail and password=:password")
				.setString("adminEmail", adminEmail).setString("password",
						password).list();
	}

	@Override
	public List<Admin> getAdminByAdminEmail(String adminEmail) {
		return sessionFactory.getCurrentSession().createQuery(
				"from Admin where adminEmail=:adminEmail").setParameter(
				"adminEmail", adminEmail).list();
	}

}
