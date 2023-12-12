package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDaoImpl implements BoardDao {
	private static final Logger log = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	private SqlSession sql;
	
	public BoardDaoImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info(">> insert check3");
		int ok = sql.insert("BoardMapper.in",bvo);
		if(ok>0) sql.commit();
		return ok;
	}

	@Override
	public List<BoardVO> list(PagingVO pgvo) {
		log.info(">> list check3");
		
		return sql.selectList("BoardMapper.list",pgvo);
	}

	@Override
	public BoardVO detail(int bno) {
		log.info(">> list check3");
		return sql.selectOne("BoardMapper.det",bno);
	}

	@Override
	public int readcountup(int bno) {
		log.info("readcount check3");
		int ok = sql.update("BoardMapper.re",bno);
		if(ok>0) sql.commit();
		return ok;
	}

	@Override
	public int update(BoardVO bvo) {
		log.info(">>>> modify check3");
		int isOk = sql.update("BoardMapper.up",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int remove(int bno) {
		log.info("remove check3");
		int ok = sql.delete("BoardMapper.del",bno);
		if(ok>0) sql.commit();
		return ok;
	}

	@Override
	public int gettotal(PagingVO pgvo) {
		log.info("total check3");
		return sql.selectOne("BoardMapper.total",pgvo);
	}

	@Override
	public String getFileName(int bno) {
	log.info(">>>>  check3");
		
		return sql.selectOne("BoardMapper.fileName",bno);
	}






}
