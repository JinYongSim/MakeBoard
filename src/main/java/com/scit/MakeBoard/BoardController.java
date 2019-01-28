package com.scit.MakeBoard;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scit.MakeBoard.DAO.BoardDAO;
import com.scit.MakeBoard.PageNavigator.PageNavigator;
import com.scit.MakeBoard.VO.Board;
import com.scit.MakeBoard.VO.Comment;

@Controller
public class BoardController {
	private static final String UPLOADPATH="C:\\Users\\SIM\\upload\\";
	private int boardPerPage=3; // 페이지당 글의 갯수
	private int pagePerGroup=3; // 페이지그룹 당 페이지의 갯수
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board() {
		return "boardWrite";
	}
	
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(MultipartFile uploadFile,Board board, HttpSession session) {
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String fileName=uploadFile.getOriginalFilename();
		String array[] = fileName.split("\\.");
		String ext = null;
		String name = null;
		if(array.length>0) {
			ext=array[array.length-1];	
			name=time1+"."+ext;
		}
		
		try {
			uploadFile.transferTo(new File(UPLOADPATH+name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = 0;
		board.setFileName(name);
		board.setFileName_org(fileName);
		board.setId((String) session.getAttribute("loginId"));
		result = dao.insertBoard(board);
		if(result == 0) {
			return "boardWrite";
		}
		else {
			return "redirect:/selectBoardList?page=1";
		}
	}
	
	@RequestMapping(value="/selectBoardList", method=RequestMethod.GET)
	public String selectBoardList(Model model,
			@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="search",defaultValue="") String search) {
//		ArrayList<Board> list = new ArrayList<Board>();
//		list = dao.selectBoardList();
//		model.addAttribute("boardList", list);
		int totalCount = dao.totalCount(search); //전체 게시글의 수
		
		PageNavigator pn = new PageNavigator(boardPerPage,pagePerGroup,page,totalCount); 
		ArrayList<Board> bList = dao.selectBoardList(pn,search);
		model.addAttribute("boardList", bList);
		model.addAttribute("navi",pn);
		model.addAttribute("search",search);
		return "board";
	}
	@RequestMapping(value="/selectBoardDetail", method= {RequestMethod.GET,RequestMethod.POST})
	public String selectBoardDetail(Model model, String boardSeq) {
		dao.increaseHitCount(boardSeq);
		Integer.parseInt(boardSeq);
		Board board = dao.selectBoardDetail(boardSeq);
		model.addAttribute("board", board);
		selectComment(boardSeq,model);
		return "boardDetail";
	}
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(String boardSeq,HttpSession session, Model model) {
		if(session.getAttribute("loginId") == null) {
			return "login";
		}
		Board board = dao.selectBoardDetail(boardSeq);
		model.addAttribute("board",board);
		return "boardWrite";
	}
	@RequestMapping(value="/updateContent", method=RequestMethod.POST)
	public String updateContent(MultipartFile uploadFile,Board board) {
		System.out.println(board);
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");
		Date time = new Date();
		String time1 = format1.format(time);
		String fileName=uploadFile.getOriginalFilename();
		String array[] = fileName.split("\\.");
		String ext = null;
		String name = null;
		if(array.length>0) {
			ext=array[array.length-1];	
			name=time1+"."+ext;
		}
		
		try {
			uploadFile.transferTo(new File(UPLOADPATH+name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		board.setFileName(name);
		board.setFileName_org(fileName);
		System.out.println(board);
		dao.updateBoard(board);
		return "redirect:/selectBoardList";
	}
	
	
	@RequestMapping(value="/fileDownLoad", method=RequestMethod.GET)
	public void fileDownload(String fileName,HttpServletResponse response,String boardSeq) {
		Integer.parseInt(boardSeq);
		Board board = dao.selectBoardDetail(boardSeq);
		fileName=board.getFileName_org();
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileInputStream fis;
		ServletOutputStream sos;
		
		try {
			fileName=board.getFileName();
			fis=new FileInputStream(UPLOADPATH+fileName);
			sos=response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);
			sos.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteBoard(String boardSeq, HttpSession session) {
		Board board = dao.selectBoardDetail(boardSeq);
		if(board.getId().equals((String)session.getAttribute("loginId"))) {
			dao.deleteBoard(boardSeq);
		}
		return "redirect:/selectBoardList";
	}
	
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
	public String insertComment(Comment comment,Model model,String comments,String boardSeq) {
		
		if(!comments.equals("")) {
			dao.insertComment(comment);
		}
		selectComment(comment.getBoardSeq()+"",model);
		selectBoardDetail(model, comment.getBoardSeq()+"");
		return "redirect:/selectBoardDetail?boardSeq="+comment.getBoardSeq();
		/*return "forward:/selectBoardDetail";*/
	}
	
	
	public void selectComment(String boardSeq, Model model) {
		ArrayList<Comment> cList = null;
		cList = dao.selectComment(boardSeq);
		model.addAttribute("cList", cList);
		
	}
	
	@RequestMapping(value="/deleteComment", method=RequestMethod.POST)
	public String deleteComment(String commentSeq,String boardSeq,HttpSession session,Model model) {
		dao.deleteComment(commentSeq);
		selectComment(boardSeq, model);
		selectBoardDetail(model, boardSeq);
		return "boardDetail";
	}
} //Controller 끝
