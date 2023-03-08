package co.dev.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.dev.common.DataSource;
import co.dev.mapper.NoticeMapper;
import co.dev.vo.NoticeVO;

public class NoticeServiceMybatis implements NoticeService{
	
	//jdbc : NoticeDAO dao;
	//mybatis : mapper;
	SqlSession sqlSession = DataSource.getInstance().openSession(true);//true:자동커밋
	NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
	
	@Override
	public List<NoticeVO> noticeList(int page) {
		//return mapper.noticeList();
		return mapper.noticeListWithPaging(page);
	}

	@Override
	public boolean addNotice(NoticeVO vo) {
		int r = mapper.insertNotice(vo);
		//sqlSession.commit();//다른 세션에서도 반영되게끔
		return r==1;
	}

	@Override
	public NoticeVO getNotice(int nid) {
		mapper.updateCount(nid);//조회수 증가
		return mapper.selectNotice(nid);
	}

	@Override
	public int getTotalCount() {
		return mapper.getTotalCount();
	}

	@Override
	public boolean noticeModify(NoticeVO vo) {
		int r = mapper.updateNotice(vo);
		return r==1;
	}

	@Override
	public int noticeRemove(int nid) {

		return mapper.deleteNotice(nid);
	}

	
	

	

	
	

	


	
}
