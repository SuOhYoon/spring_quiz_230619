package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.domain.Booking;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookingBO bo;
	
//	@GetMapping("/quiz01/add-star-view")
//	public String addStarView() {
//		return "lesson06/addStar";
//	}
//	
//	@PostMapping("/quiz01/add-star")
//	@ResponseBody
//	public Map<String, Object> addStar(@RequestParam("name")String name, @RequestParam("url")String url) {
//		bo.addStar(name, url);
//		
//		// 응답값 : JSON String
////		{
////			"code":1,
////			"result":"success"
////		}
//		Map<String, Object> result = new HashMap<>();
//		result.put("code", 200);
//		result.put("result", "success");
//		return result; // JSON String
//	}
//	
//	// url 중복 확인 -- AJAX로 요청
//	@ResponseBody
//	@RequestMapping("/quiz01/is-duplication")
//	public Map<String, Object> isDuplication(
//			@RequestParam("url")String url){
//		
//		// db 조회
//		boolean isDuplicated = bo.existStarByUrl(url);
//		
//		// 응답값
//		// {"code":200, "is_duplication":true}
//		Map<String, Object> result = new HashMap<>();
//		result.put("code", 200);
//		result.put("is_duplication", isDuplicated); // true:중복
//		return result;
//	}
//	
//	@GetMapping("/quiz01/get-star")
//	public String getStar(Model model) {
//		List<Star> list = bo.findAll();
//		model.addAttribute("list", list);
//		return "lesson06/getStar";
//	}
	
	/* quiz03 */
	// 예약 목록 보기 화면
	@GetMapping("/booking-list-view")
	public String reservationListView(Model model) {
		List<Booking> bookingList = bo.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	// 예약 삭제 기능 - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id")int id){
		
		// db insert
		bo.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result;
	}
	
	// 예약하기 화면
	@GetMapping("/add-booking-view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	// 예약 추가 - AJAX 요청
	@ResponseBody
	@PostMapping("/add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name, 
			@RequestParam("date") String date, 
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber){
		// DB insert
		bo.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result; // JSON String
	}

	// 예약 확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// 예약 조회 - AJAX 요청
	@ResponseBody
	@PostMapping("/search-booking")
	public Map<String, Object> getBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber){
		// DB select
		
		// 응답값
		// {"code":400, "error_message":"데이터가 존재하지 않습니다."}
		// {"code":200, "result":booking}
		Map<String, Object> result = new HashMap<>();
		
		Booking book = bo.getBookingByNamePhoneNumber(name, phoneNumber);
		
		if(book== null) {
			result.put("code", 400);
			result.put("error_message", "데이터가 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", book);
		}
		
		return result;
	}
}
