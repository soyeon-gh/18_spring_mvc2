package com.spring.mvc2.data_transfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.data_transfer.domain.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberDTO> selectAllMember(){
		return sqlSession.selectList("member.selectAllMember");
	}
	
	
	public void joinMember(MemberDTO memberDTO) {
		sqlSession.insert("member.insertMemberDTO" , memberDTO);
	}
	
	public void joinMember(Map<String,String> memberMap) {
		sqlSession.insert("member.insertMemberMap" , memberMap);
	}
	
	
	
	
}
