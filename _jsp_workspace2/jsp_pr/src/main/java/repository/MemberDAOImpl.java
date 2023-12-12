package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();	
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("register check3");
		int ok = sql.insert("MemberMapper.reg",mvo);
		if(ok>0)sql.commit();
		return ok;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login check3");
		return sql.selectOne("MemberMapper.log",mvo);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("login check3");
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info("modify check3");
		int ok =sql.update("MemberMapper.up",mvo);
		if(ok>0) sql.commit();
		return ok;
	}

	@Override
	public int remove(String id) {
		log.info("remove check3");
		int ok = sql.delete("MemberMapper.del",id);
		if(ok>0)sql.commit();
		return ok;
	}

	@Override
	public int lastlogin(String id) {
		log.info("lastlogin check3");
		int ok = sql.update("MemberMapper.last",id);
		if(ok>0) sql.commit();
		return ok;
	}




}
