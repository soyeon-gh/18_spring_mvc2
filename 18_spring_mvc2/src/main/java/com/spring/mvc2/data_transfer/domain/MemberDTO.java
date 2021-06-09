package com.spring.mvc2.data_transfer.domain;

import org.springframework.stereotype.Component;

/*
 *  @Component 
 *    
 *  - 컴포넌트 어노테이션을 등록한 클래스의 객체를 스프링 bean으로 등록시켜서 
 *    IoC 컨테이너의 관리하에 객체의 라이프사이클(객체의 생성,초기화,소멸 등)이 관리된다.
 *  
 *  - Component("member")와 같은 별도의 이름 지정이 가능하며 이름을 지정하지 않을 경우
 *  클래스의 앞글자를 소문자로 바꾼 값을 스프링 bean으로 등록한다. ex) memberDTO
 *  
 *  - (중요)servelet-context.xml 파일의 <context:component-scan base-package="com.spring.mvc2" />의 지정된 경로에 
 *     컴포넌트 등록이 있어야 컴포넌트 스캔이 가능하다.
 *  
 *  - @Component 외 @Controller , @Service , @Repository , @Aspect , @Configuration 어노테이션도 컴포넌트 스캔 대상이 된다. 
 *  
 */

@Component("memberDTO")
public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birthY;
	private String birthM;
	private String birthD;
	private String birthGn;
	private String hp1;
	private String hp2;
	private String hp3;
	private String smsstsYn;
	private String email;
	private String emailstsYn;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthY() {
		return birthY;
	}
	public void setBirthY(String birthY) {
		this.birthY = birthY;
	}
	public String getBirthM() {
		return birthM;
	}
	public void setBirthM(String birthM) {
		this.birthM = birthM;
	}
	public String getBirthD() {
		return birthD;
	}
	public void setBirthD(String birthD) {
		this.birthD = birthD;
	}
	public String getBirthGn() {
		return birthGn;
	}
	public void setBirthGn(String birthGn) {
		this.birthGn = birthGn;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getSmsstsYn() {
		return smsstsYn;
	}
	public void setSmsstsYn(String smsstsYn) {
		this.smsstsYn = smsstsYn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailstsYn() {
		return emailstsYn;
	}
	public void setEmailstsYn(String emailstsYn) {
		this.emailstsYn = emailstsYn;
	}
	
}
