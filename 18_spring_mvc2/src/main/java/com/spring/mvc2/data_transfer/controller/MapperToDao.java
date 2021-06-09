package com.spring.mvc2.data_transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc2.data_transfer.dao.OrderDAO;

@Controller
@RequestMapping("mTOd")
public class MapperToDao {

	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping(value="/orderList")
	public String orderList(Model model) {
		
		model.addAttribute("from" , "orderList");
		model.addAttribute("orderList" , orderDAO.selectAllData());
		
		return "order/orderList";
		
	}
	
	
	@RequestMapping(value="/selectData1")
	public String selectData1(Model model) {
		model.addAttribute("from", "selectData1");
		model.addAttribute("rowCount", orderDAO.selectData1());
		return "order/select1";
	}
	
	
	@RequestMapping(value="selectData2")
	public String selectData2(Model model) {
		model.addAttribute("from" , "selectData2");
		model.addAttribute("orderList" , orderDAO.selectData2());
		return "order/select2";
	}
	
	
	@RequestMapping(value = "/selectData3")
	public String selectData3(Model model) {
		model.addAttribute("from" , "selectData3");
		model.addAttribute("orderList" , orderDAO.selectData3());
		return "order/select3";
	}
	
	
	@RequestMapping(value = "/selectData4")
	public String selectData4(Model model) {
		model.addAttribute("from" , "selectData4");
		model.addAttribute("orderList" , orderDAO.selectData4());
		return "order/select3";
	}
	
	
	
	
}
