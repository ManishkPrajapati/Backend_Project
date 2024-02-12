package com.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Advertisment;
import com.demo.repository.AdvertismentRepo;
import com.demo.repository.CategoryRepo;
import com.demo.repository.UserRepo;
import com.demo.service.AdvertismentService;

@Service
public class AdvertismentImpl implements AdvertismentService{
	@Autowired
	private AdvertismentRepo addRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	

	@Override
	public Advertisment createAdd(Advertisment add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisment> getAllAdd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertisment updateAdd(Advertisment add, Integer addId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertisment deleteAdd(Integer addId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertisment getAddById(Integer addId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Advertisment getAddByCategory(String addCategory) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
