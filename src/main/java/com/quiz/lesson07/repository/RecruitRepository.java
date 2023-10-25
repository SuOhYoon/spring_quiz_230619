package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	// Spring Data JPA
	// findById
	
	// JPQL => 엔티티 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String Type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String Type, int salary);
	public List<RecruitEntity> findByTop3ByTypeOrderBySalaryDesc(String Type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd);
	
	// NativeQuery
	@Query(value = "select * from `recruit` "
			+ "where `deadline` > :deadline"
			+ " and `salary` >= :salary "
			+ "and `type` = :type "
			+ "order by salary desc", nativeQuery=true)
	public List<RecruitEntity> findByDeadLineAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type);
}
