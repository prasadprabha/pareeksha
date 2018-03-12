package com.exam.dao;

import java.util.List;

import com.exam.model.Admin;

public interface AdminDao {
	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
}
