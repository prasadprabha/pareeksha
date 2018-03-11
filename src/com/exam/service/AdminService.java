package com.exam.service;

import java.util.List;

import com.exam.model.Admin;

public interface AdminService {
	public List<Admin> validateLoginAdmin(String adminEmail, String password);

	public List<Admin> getAdminByAdminEmail(String adminEmail);
}
