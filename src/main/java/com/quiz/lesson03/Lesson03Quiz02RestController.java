package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealestateBO;
import com.quiz.lesson03.domain.Realestate;

@RestController
public class Lesson03Quiz02RestController {
	
	@Autowired
	RealestateBO realestateBO;
	
	@RequestMapping("/lesson03/quiz02/1")
	public String quiz02_1() {
		Realestate realestate = new Realestate();
		realestate.setRealtorId(3);
		realestate.setAddress("푸르지용 리버 303동 1104호");
		realestate.setArea(89);
		realestate.setType("매매");
		realestate.setPrice(100000);
		int rowcount = realestateBO.addRealestate(realestate);
		return "성공된 행의 개수 : " + rowcount;
	}
	
	@RequestMapping("/lesson03/quiz02/2")
	public String quiz02_2(@RequestParam("realtor_id")int realtor_id) {
		Realestate realestate = new Realestate();
		realestate.setRealtorId(realtor_id);
		realestate.setAddress("썅떼빌리버 오피스텔 814호");
		realestate.setArea(45);
		realestate.setType("월세");
		realestate.setPrice(100000);
		realestate.setRentPrice(120);
		int rowcount = realestateBO.addRealestate(realestate);
		return "입력 성공 : " + rowcount;
	}
}	
