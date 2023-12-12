package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDao;
import repository.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDao bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDaoImpl();
	}

//	@Override
//	public int insert(BoardVO bvo) {
//		log.info(">> insert check2");
//		return bdao.insert(bvo);
//	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info(">> list check2");
		return bdao.list(pgvo);
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info(">> detail check2");
		int ok = bdao.readcountup(bno);
		return bdao.detail(bno);
	}

//	@Override
//	public int edit(BoardVO bvo) {
//		log.info(">> edit check2");
//		return bdao.edit(bvo);
//	}

	@Override
	public int remove(int bno) {
		log.info(">> remove check2");
		return bdao.remove(bno);
	}

	@Override
	public int gettotal(PagingVO pgvo) {
		log.info(">> total check2");
		return bdao.gettotal(pgvo);
	}

	@Override
	public int register(BoardVO bvo) {
		log.info(">>>>> insert check2");
		return bdao.insert(bvo);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info(">>>> modify check2");
		return bdao.update(bvo);
	}

	@Override
	public String getFileName(int bno) {
		log.info(">>>> FileName check2");
		return bdao.getFileName(bno);
	}




}
