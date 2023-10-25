package com.quiz.lesson06.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.StarDAO;
import com.quiz.lesson06.domain.Star;

@Service
public class StarBO {
	@Autowired
	private StarDAO dao;
	
	public void addStar(String name, String url) {
		dao.insertStar(name, url);
	}
	
	public List<Star> findAll(){
		return dao.selectAll();
	}
	
	public boolean existStarByUrl(String url) {
		return dao.existStarByUrl(url);
	}
}
