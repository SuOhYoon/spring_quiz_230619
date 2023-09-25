package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.Realestate;
import com.quiz.lesson03.mapper.RealestateMapper;

@Service
public class RealestateBO {
	@Autowired
	private RealestateMapper realestateMapper;
	
	public Realestate selectOne(int id) {
		return realestateMapper.selectOne(id);
	}
	
	public List<Realestate> selectOthers(int rentPrice){
		return realestateMapper.selectOthers(rentPrice);
	}
	
	public List<Realestate> selectOther(int area, int price){
		return realestateMapper.selectOther(area, price);
	}
	
	public int addRealestate(Realestate realestate) {
		return realestateMapper.insertRealestate(realestate);
	}
}
