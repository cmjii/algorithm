package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDao {

	int insert(BoardVO bvo);

	List<BoardVO> list(PagingVO pgvo);

	BoardVO detail(int bno);

	int readcountup(int bno);

	//int edit(BoardVO bvo);

	int remove(int bno);

	int gettotal(PagingVO pgvo);

	int update(BoardVO bvo);

	String getFileName(int bno);




}
