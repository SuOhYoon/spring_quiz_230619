package com.quiz.lesson07.entity;

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
@Getter
@Builder(toBuilder = true)    // 필드 세팅, toBuilder=true: 기존 객체에 일부 필드값만 변경 가능
@NoArgsConstructor  // 파라미터 없는 생성자
@AllArgsConstructor // 모든 필드 있는 생성자
@Table(name = "company")   // 테이블명과 클래스명이 동일하면 생략 가능
@Entity  // DB테이블 필수!
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String business;
	private String scale;
	private String headcount;
	
	@UpdateTimestamp
	@Column(name="createdAt", updatable = false)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updateAt")
	private ZonedDateTime updateAt;
}
