package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.Realestate;

@Repository
public interface RealestateMapper {
	public Realestate selectOne(int rentPrice);
	public List<Realestate> selectOthers(int rentPrice);
	public List<Realestate> selectOther(@Param("area")int area, @Param("price")int price);
	public int insertRealestate(Realestate realestate);
	public int updateRealestate(@Param("id")int id, 
								@Param("type")String type, 
								@Param("price")int price);
	public int deleteRealestate(int id);
}
