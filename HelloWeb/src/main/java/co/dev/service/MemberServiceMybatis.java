package co.dev.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dev.common.DataSource;
import co.dev.mapper.MemberMapper;
import co.dev.vo.MemberVO;

public class MemberServiceMybatis implements MemberService{
	
	//jdbc : MemberDAO dao;
	//mybatis : DataSource : SqlSessionFactory -> SqlSession;
	private SqlSession sqlSession = DataSource.getInstance().openSession();
	//Mapper.xml파일의 메소드 호출
	private MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> getMembers() {
		return mapper.getMembers();
	}

	@Override
	public boolean addMember(MemberVO vo) {
		return false;
	}

	@Override
	public MemberVO getMember(String id) {
		return null;
	}

	@Override
	public boolean modifyMember(MemberVO vo) {
		return false;
	}

	@Override
	public boolean removeMember(String id) {
		return false;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return mapper.login(vo);
	}

}
