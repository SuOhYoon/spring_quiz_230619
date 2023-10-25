package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Star;

@Repository
public interface StarDAO {
	public void insertStar(@Param("name")String name, @Param("url")String url);
	public List<Star> selectAll();
	public boolean existStarByUrl(String url);
}
