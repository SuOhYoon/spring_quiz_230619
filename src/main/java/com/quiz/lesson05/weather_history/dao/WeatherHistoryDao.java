package com.quiz.lesson05.weather_history.dao;

import java.util.List;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;

public interface WeatherHistoryDao {
	public List<WeatherHistory> selectAll();
}
