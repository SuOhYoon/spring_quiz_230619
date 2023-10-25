package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz")
public class Lesson07RestController {
	
	@Autowired
	private CompanyBO companyBO;
	// CRD
	// Create
	
	@GetMapping("/save1")
	public CompanyEntity create() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		String headcount = "3585";
		
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/save2")
	public CompanyEntity create2() {
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		String headcount = "6834";
		
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateCompanyScaleAndHeadCountById(8, "중소기업", "34");
	}
	
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteStudentById(8);
		return "수행 완료";
	}
}
