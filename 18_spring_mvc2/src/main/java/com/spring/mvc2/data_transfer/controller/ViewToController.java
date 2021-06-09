package com.spring.mvc2.data_transfer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc2.data_transfer.dao.MemberDAO;
import com.spring.mvc2.data_transfer.domain.MemberDTO;

@Controller
@RequestMapping("vTOc")
public class ViewToController {

	@Autowired
	private MemberDAO memberDAO;
	
	/*
	 *	전송방식을 지정해 GET과 POST 방식을 다른 메서드로 처리할 수 있다.
	 *	명시하지 않을 경우 GET과 POST방식을 모두 처리한다.
	 *	@GetMapping("/transfer1") 과 같이 어노테이션을 이용한 설정도 가능하다.
	 *	@RequestMapping("/transfer1")
	 */
	
	@RequestMapping(value="/")
	public String main() {
		return "member/joinForm";
	}
	
	@RequestMapping("/list1") 
	public String list1(Model model) {
		
		model.addAttribute("from", "list1");
		model.addAttribute("memberList" , memberDAO.selectAllMember());
		
		return "member/memberList";
	}
	
	
	/* 
	 * 	
	 * 	예시 1)  HttpServletRequest
	 * 
	 *  HttpServletRequest를 직접 이용하여 getParameter메서드를 이용하여 파라메타의 값에 접근 할 수 있다.
	 *  jsp에서의 사용법과 같다.
	 * 
	 */
	
	@RequestMapping(value="/transfer1")
	public String transfer1(HttpServletRequest request) {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId(request.getParameter("id"));
		memberDTO.setPw(request.getParameter("pw"));
		memberDTO.setName(request.getParameter("name"));
		memberDTO.setGender(request.getParameter("gender"));
		memberDTO.setBirthY(request.getParameter("birthY"));
		memberDTO.setBirthM(request.getParameter("birthM"));
		memberDTO.setBirthD(request.getParameter("birthD"));
		memberDTO.setBirthGn(request.getParameter("birthGn"));
		memberDTO.setHp1(request.getParameter("hp1"));
		memberDTO.setHp2(request.getParameter("hp2"));
		memberDTO.setHp3(request.getParameter("hp3"));
		memberDTO.setSmsstsYn(request.getParameter("smsstsYn"));
		memberDTO.setEmail(request.getParameter("email"));
		memberDTO.setEmailstsYn(request.getParameter("emailstsYn"));
		
		memberDAO.joinMember(memberDTO);
		
		return "redirect:/vTOc/list1";
		
		/*
		 *
		 * 	특정 페이지로 리다이렉트시키는 방법은 "redirect:경로" 와 같은 형태로 간단하다.
		 *	jsp 페이지로 이동하는 방법과 url로 리다이렉트하는 방법의 차이점은 중요하므로 잘 기억하여야 한다.
		 *	 
		 *		jsp로 이동하는 경우 : 순수하게 페이지만 이동  
		 *		redirect하는 경우   : 해당 url에 있는 모든 로직을 수행한후 페이지 이동.
		 *
		 */
		
	}
	
	
	
	/*
	 * 
	 *  예시 2) 커멘드 객체를 사용
	 *  
	 *  예시 1번과 같은 방법은 요청 파라미터 개수가 증가할때마다 코드의 길이도 길어지는 단점이 있다. 
	 *  만약 파라메타의 개수가 20개면 파라미터의 값을 읽어와 설정하는 코드만 최소 40줄 이상 작성해야 한다.
	 *  
	 *  name인 요청 파라미터의 값을 커맨드 객체(pojo)의 setter 메서드를 사용해서 커맨드 객체에 전달한다.
	 *  
	 *  커맨드 객체라고 해서 특별한 코드를 작성하는 것이 아니라 pojo를 사용해주면 된다.
	 *  
	 */
	
	@RequestMapping(value="/transfer2")
	public String transfer2(MemberDTO memberDTO) {
		memberDAO.joinMember(memberDTO);
		return "redirect:/vTOc/list1";
	}
	
	
	
	/* 
	 * 예시 3) Map 컬렉션 프레임워크 이용
	 * 
	 * Map 인터페이스를 이용하여 요청파라미터에 접근이 가능하다.
	 * 
	 */
	@RequestMapping(value="/transfer3")
	public String transfer3(@RequestParam Map<String,String> memberMap) {
		memberDAO.joinMember(memberMap);
		return "redirect:/vTOc/list1";
	}
	
	
	
	/* 
	  
	 	예시 4) [ 특정 값만 입력받기 ] requestParam 이용
	
		- 요청 파라미터의 개수가 얼마 되지 않는다면 @RequestParam어노테이션을 사용하여 파라메타의 값에 접근 할 수 있다. 
		- @RequestParam 어노테이션의 속성
		
			name 		 : 파라메타의 이름을 지정한다. 
			required	 : 필수 여부를 지정한다. 기본값은 true이며 요청값이 없으면 익셉션이 발생한다.
			defaultValue : 요청 파라미타의 값이 없을때 사용할 값을 지정한다.
	
   */
	
	@RequestMapping(value="/transfer4")
	public String transfer4(@RequestParam(name="id" , defaultValue = "user") String id ,
							@RequestParam(name="pw" , defaultValue = "1234") String pw ,
							@RequestParam(name="name" , defaultValue = "anonymous") String name ) {
		
		Map<String, String> memberMap = new HashMap<String, String>();
		
		memberMap.put("id", id);
		memberMap.put("pw", pw);
		memberMap.put("name", name);
		
		memberDAO.joinMember(memberMap);
		
		
		return "redirect:/vTOc/list1";
	}
	
	
	
	/* 
	 * 예시 5) [ 특정 값만 입력받기 ] parameter에 직접 name값만 입력
	 * 
	 * 메서드의 파라미터에 name값을 직접 입력하여 파라메타에 접근이 가능하지만 , 
	 * 가독성 향상 및 코드의 통일성을 위해 @RequestParam 어노테이션 사용을 권장한다.
	 * 
	 */
	
	@RequestMapping(value="/transfer5")
	public String transfer5(String id , String pw , String name) {
		
		Map<String, String> memberMap = new HashMap<String, String>();
		
		memberMap.put("id", id);
		memberMap.put("pw", pw);
		memberMap.put("name", name);
		
		memberDAO.joinMember(memberMap);
		
		
		return "redirect:/vTOc/list1";
	}
	
	
	
	
	
}
