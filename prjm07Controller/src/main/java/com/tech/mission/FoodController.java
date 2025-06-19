package com.tech.mission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FoodController {

	@RequestMapping("/food/foodform")
	public String foodform() {
		
		return "/food/foodform";
	}
	
	@RequestMapping("/food/foodview")
	public String foodview(HttpServletRequest request, Model model) {
		String store = request.getParameter("store");
		String menu = request.getParameter("menu");
		String price = request.getParameter("price");
		model.addAttribute("store", store);
		model.addAttribute("menu", menu);
		model.addAttribute("price", price);
		
		return "/food/foodview";
	}
	
}


// /food/foodform -> 데이터 입력(가게, 메뉴명, 가격)
// /food/foodview -> 데이터 출력