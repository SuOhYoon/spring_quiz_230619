package com.quiz.lesson07.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "recruit")
public class RecruitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	
	@Column(name = "companyId")
	int companyId;
	
	String position;
	
	String responsibilites;
	
	String qualification;
	
	String type;
	
	String region;
	
	int salary;
	
	LocalDate deadline; // 시분초 없음
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updateAt")
	ZonedDateTime updateAt;
}
