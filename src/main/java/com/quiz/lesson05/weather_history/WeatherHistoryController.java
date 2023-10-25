package com.quiz.lesson05.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.weather_history.bo.WeatherHistoryBO;
import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 목록 화면
	// http://localhost:8080/weather/history-view
	@GetMapping("/history-view")
	public String historyView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather_history/history";
	}
	
	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {	
		return "weather_history/addWeather";
	}
}
