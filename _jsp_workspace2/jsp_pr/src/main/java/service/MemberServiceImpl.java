package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {

	public static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("register check2");
		return mdao.register(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login check2");
		return mdao.login(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("list check2");
		return mdao.getList();
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info("modify check2");
		return mdao.modify(mvo);
	}

	@Override
	public int remove(String id) {
		log.info("remove check2");
		return mdao.remove(id);
	}

	@Override
	public int logout(String id) {
		log.info("remove check2");
		return mdao.lastlogin(id);
	}



	
}
