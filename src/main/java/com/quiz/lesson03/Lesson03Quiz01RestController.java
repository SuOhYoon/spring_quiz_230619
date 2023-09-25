package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealestateBO;
import com.quiz.lesson03.domain.Realestate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	@Autowired
	private RealestateBO realestateBO;
	
	@RequestMapping("/1")
	public Realestate getselectOne(@RequestParam(value="id")int id) {
		return realestateBO.selectOne(id);
	}
	
	@RequestMapping("/2")
	public List<Realestate> selectOthers(@RequestParam(value="rent_price")int rentPrice){
		List<Realestate> list = realestateBO.selectOthers(rentPrice);
		return list;
		
	}
	
	@RequestMapping("/3")
	public List<Realestate> selectOther(@RequestParam(value="area")int area, @RequestParam(value="price")int price){
		List<Realestate> list = realestateBO.selectOther(area, price);
		return list;
	}
}
