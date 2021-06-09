package com.spring.mvc2.data_transfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc2.data_transfer.dao.OrderDAO;
import com.spring.mvc2.data_transfer.domain.OrderDTO;

@Controller
@RequestMapping("dTOm") // 공통되는 경로는 Controller위에 url 경로를 명시하여
						// 코드의 중복을 줄일 수 있다.
public class DaoToMapper {

	@Autowired
	private OrderDAO orderDAO;
	
	// DAO > Mapper 전송 예시 1) 단일 데이터 전송
	@RequestMapping(value="/insertData1")
	public String insertData1() {
		//String productName = "기계식키보드";
		//String productName = "무소음 마우스";
		String productName = "장패드";
		orderDAO.insertOne(productName);
		return "redirect:/mTOd/orderList";
	}
	
	
	// DAO > Mapper 전송 예시 2) DTO 클래스 전송
	@RequestMapping(value="/insertData2")
	public String insertData2() {
		
		OrderDTO oDto = new OrderDTO();
		
		oDto.setMemberId("임시 유저1");
		oDto.setProductCode("임시 상품코드1");
		oDto.setProductName("임시 상품명1");
		orderDAO.insertDTO(oDto);
		
		return "order/orderList";
	}
	
	
	// DAO > Mapper 전송 예시 3) Map 데이터 전송
	@RequestMapping(value="/insertData3")
	public String insertData3() {
		
		Map<String,String> orderMap = new HashMap<String,String>();
		orderMap.put("memberId"    , "임시 유저2");
		orderMap.put("productCode" , "임시 상품코드2");
		orderMap.put("productName" , "임시 상품명2");
		orderDAO.insertMap(orderMap);
		
		return "order/orderList";
	}
	
	
}
