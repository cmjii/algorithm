package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	//int insert(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(int bno);

	//int edit(BoardVO bvo);

	int remove(int bno);

	int gettotal(PagingVO pgvo);

	int register(BoardVO bvo);

	int modify(BoardVO bvo);

	String getFileName(int bno);






}
