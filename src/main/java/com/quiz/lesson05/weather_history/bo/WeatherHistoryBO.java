package com.quiz.lesson05.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.weather_history.dao.WeatherHistoryDao;
import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryDao weatherHistoryMapper;

	// input:X,  output:List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectAll();
	}
}