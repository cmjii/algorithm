package repository;

import java.util.List;

import domain.BoardVO;
import domain.MemberVO;

public interface MemberDAO {

	int register(MemberVO mvo);

	MemberVO login(MemberVO mvo);

	List<MemberVO> getList();

	int modify(MemberVO mvo);

	int remove(String id);

	int lastlogin(String id);



}
