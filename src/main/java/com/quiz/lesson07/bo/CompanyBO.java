package com.quiz.lesson07.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity addCompany(String name, String business, String scale, String headcount) {
		CompanyEntity company = CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.createdAt(ZonedDateTime.now())
				.build();
		return companyRepository.save(company);
	}
	
	public CompanyEntity updateCompanyScaleAndHeadCountById(int id, String scale, String headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		if (company != null) {
			// 기존값은 유지하고 세팅된 일부값만 변경(dreamJob만 변경) => toBuilder
			company = company.toBuilder()
				.scale(scale)
				.headcount(headcount)
				.build();
			
			// update
			company = companyRepository.save(company); // db update후 다시 셀렉트 된 결과값
		}
		
		return company; // null 또는 변경된 데이터
	}
	
	public void deleteStudentById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(s -> companyRepository.delete(s));
	}
}
