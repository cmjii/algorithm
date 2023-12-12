package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.FileRemoveHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;



@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);	
	private RequestDispatcher rdp;	
	private String destpage;
	private int ok;
	private BoardService bsv;
	
	private String savePath; //파일저장경로를 저장하는 변수
	
    public BoardController() {
    	bsv = new BoardServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch(path) {
		case "register" : 
			destpage = "/board/register.jsp";
			break;
		
		case "insert" :
		try {
			//파일을 업로드할 물리적인 경로 설정
			savePath = getServletContext().getRealPath("/_fileUpload"); //(서버)서블릿이 가지고 있는 기본 설정 정보를 가져오는 것 
												//△webapp에 있는 fileUpload경로를 가져온 것
			//savePath = getServletContext().getRealPath(); //(webapp)경로
			File fileDir = new File(savePath); //파일의 경로를 가지고 있는 객체 생성
			log.info("저장위치 : "+savePath);
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(fileDir); //저장할 위치를 file객체로 지정
			fileItemFactory.setSizeThreshold(1024*1024*3);//<-3메가 //파일 저장을 위한 임시 메모리 용량 설정 : byte단위
			//미리 객체 설정
			BoardVO bvo = new BoardVO();
			//multipart/for-data형식으로 넘어온 request객체를 다루기 쉽게 변환해주는 역할 
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			//commons껄로 import
			List<FileItem> itemList = fileUpload.parseRequest(request);
			for(FileItem item : itemList) {
				switch(item.getFieldName()) {
				case "title" :
					bvo.setTitle(item.getString("utf-8"));
					break;
				case "writer" :
					bvo.setWriter(item.getString("utf-8"));
					break;
				case "content" :
					bvo.setContent(item.getString("utf-8"));
					break;
				case "image_file" :
					//이미지 있는 체크
					if(item.getSize() >0) { //데이터의 크기를 바이트 단위로 리턴 / 크기가 0보다 큰지 체크 
						String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1); //경로를 포함한 이름 ~~~~/dog.jpg //이름만 분리 -> dog.jpg
						//File.separator : 파일 경로 기호를 저장
						//시스템의 시간을 이용하여 파일을 구분   시간_dog.jpg
						fileName = System.currentTimeMillis()+"_"+fileName;
						File uploadFilePath = new File(fileDir+File.separator+fileName);
						log.info("uploadFilePath>>"+uploadFilePath.toString());
						
						//저장
						try {
							item.write(uploadFilePath); //자바 객체를 디스크에 쓰기
							bvo.setImageFile(fileName); //bvo에 저장할 값 설정
							
							//썸네일 작업 : 리스트 페이지에서 트래픽 과다사용 방지
							Thumbnails.of(uploadFilePath).size(75, 75).toFile(new File(fileDir+File.separator+"th_"+fileName));
							
						} catch (Exception e) {
							e.printStackTrace();
							log.info(">>file writer on disk error");
						}
						
					}
					break;
				}
			}
			
			ok=bsv.register(bvo);
			log.info("board register >>>> {} ",ok >0? "OK": "Fail");
			destpage="list";
			
		} catch (Exception e) {
			log.info("insert Error");
			e.printStackTrace();
		}
		break;
			
//			try {
//				String title = request.getParameter("title");
//				String writer = request.getParameter("writer");
//				String content = request.getParameter("content");
//				BoardVO bvo = new BoardVO(title, writer, content);
//				ok = bsv.insert(bvo);
//				log.info(">>> ok "+(ok>0? "OK":"Fail"));
//				destpage = "/index.jsp";
//			} 
			
		case "list" :
				try {
					//페이지네이션
					PagingVO pgvo = new PagingVO();
					log.info(request.getParameter("pageNo"));
					if(request.getParameter("pageNo") != null) {
						int pageNo = Integer.parseInt(request.getParameter("pageNo"));
						int qty = Integer.parseInt(request.getParameter("qty"));
						String type = request.getParameter("type");
						String keyword = request.getParameter("keyword");
						log.info(">>> pageNo / qty"+pageNo +"/"+qty+" / "+type+" / " + keyword);
						pgvo = new PagingVO(pageNo, qty,type,keyword);
					}
					int totalCount = bsv.gettotal(pgvo);
					PagingHandler ph = new PagingHandler(pgvo, totalCount);
					request.setAttribute("ph", ph);
					//리스트
					List<BoardVO> list=bsv.getList(pgvo);
					request.setAttribute("list", list);
					destpage = "/board/list.jsp";
				} catch (Exception e) {
					e.printStackTrace();
					log.info("list ERROR");
				}
			break;
			
		case "detail" :
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.getDetail(bno);
				request.setAttribute("bvo", bvo);
				destpage="/board/detail.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info("detail ERROR");
			}
			break;
		case "modify":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = bsv.getDetail(bno);
				request.setAttribute("bvo", bvo);
				destpage="/board/modify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("modify ERROR");
			}
			break;
		case "edit":
			try {
				savePath = getServletContext().getRealPath("/_fileUpload"); //실제 파일 경로 추출
				File fileDir = new File(savePath); //파일 객체 생성
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(); //파일 업로드를 처리하기 위한 기본적인 설정
				fileItemFactory.setRepository(fileDir); //임시 저장소 설정
				fileItemFactory.setSizeThreshold(1024*1024*3);
				BoardVO bvo = new BoardVO();
				
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory); //fileItemFactory객체를 해당 객체를 통해 업로드 파일을 처리
				
				List<FileItem> itemList = fileUpload.parseRequest(request); //FileItem -> commons라이브러리에서 제공 멀티파트와 업로드 요청을 처리
				String old_file=null;
				
				for(FileItem item : itemList) {
					switch(item.getFieldName()) {
					case"bno":
						bvo.setBno(Integer.parseInt(item.getString("utf-8")));
						break;
					case"title":
						bvo.setTitle(item.getString("utf-8"));
						break;
					case"content":
						bvo.setContent(item.getString("utf-8"));
						break;
					case"image_file":
						//이전 파일의 보관용
						old_file=item.getString("utf-8");
						break;
					case"new_file":
						//새로운 파일은 등록이 될 수도, 안될 수도 있음.
						if(item.getSize()>0) {
							//새로운 등록 파일이 있다면
							if(old_file!=null) {
								//old_file 삭제 작업
								//파일 삭제 핸들러를 통해서 파일 삭제 작업 진행
								//핸들러 객체 생성 후 값 넣어서 진행 isok
								FileRemoveHandler frh = new FileRemoveHandler();
								ok = frh.deleteFile(old_file, savePath);
							}
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							log.info("new File Name ---> "+fileName);
							
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFilepath = new File(fileDir+File.separator+fileName);
							
							try {
								
								item.write(uploadFilepath);
								bvo.setImageFile(fileName);
								
								//썸네일 작업
								Thumbnails.of(uploadFilepath).size(75, 75).toFile(new File(fileDir+File.separator+"th_"+fileName));
								
								
								
							} catch (Exception e) {
								log.info("File update Error");
								e.printStackTrace();
							}
						}else {
							//기존 파일은 있지만, 새로운 이미지 파일이 없다면..
							bvo.setImageFile(old_file); //기존 객체를 bvo에 담기
						}
						break;
					}
				}
				
				 ok = bsv.modify(bvo); 
				 log.info("edit >> {}",ok>0? "OK" : "Fail");
				 destpage="list"; //내부 list case로 이동
				
				
			} catch (Exception e) {
				log.info("edit Error");
				e.printStackTrace();
			}
			break;
//				int bno = Integer.parseInt(request.getParameter("bno"));
//				String title = request.getParameter("title");
//				String content = request.getParameter("content");
//				BoardVO bvo = new BoardVO(bno, title, content);
//				ok = bsv.edit(bvo);
//				destpage = "/brd/list";
		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("remove check1");
				savePath = getServletContext().getRealPath("/_fileUpload"); //실제 파일 경로 추출
				String FileName = bsv.getFileName(bno);
				int isDel=0;
				if(FileName != null) {
					log.info("FileName >>> "+FileName);
					FileRemoveHandler fh = new FileRemoveHandler();
					isDel = fh.deleteFile(FileName, savePath);
					log.info("isDel>>> "+isDel);
				}
				
				ok = bsv.remove(bno);
				log.info("remove >> {}",ok>0? "OK":"Fail");
				destpage = "/brd/list";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("remove ERROR");
			}
			break;
	
		}

		rdp = request.getRequestDispatcher(destpage);
		rdp.forward(request, response); //요청에 필요한 객체를 가지고 destPage 경로로 전송
		
	}

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
