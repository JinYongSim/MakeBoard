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
import org.springframework.web.multipart.MultipartFile;

import com.scit.MakeBoard.DAO.BoardDAO;
import com.scit.MakeBoard.VO.Board;

@Controller
public class BoardController {
	private static final String UPLOADPATH="C:\\Users\\SIM\\upload\\";
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
		

		System.out.println(name);
		
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
			return "redirect:/selectBoardList";
		}
	}
	
	@RequestMapping(value="/selectBoardList", method=RequestMethod.GET)
	public String selectBoardList(Model model) {
		ArrayList<Board> list = new ArrayList<Board>();
		list = dao.selectBoardList();
		model.addAttribute("boardList", list);
		return "board";
	}
	
	@RequestMapping(value="/selectBoardDetail", method=RequestMethod.GET)
	public String selectBoardDetail(Model model, String boardSeq) {
		Integer.parseInt(boardSeq);
		Board detail = dao.selectBoardDetail(boardSeq);
		model.addAttribute("detail", detail);
		return "boardDetail";
	}
	
	@RequestMapping(value="/fileDownLoad", method=RequestMethod.GET)
	public void fileDownload(String fileName,HttpServletResponse response,String boardSeq) {
		Integer.parseInt(boardSeq);
		Board detail = dao.selectBoardDetail(boardSeq);
		fileName=detail.getFileName_org();
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileInputStream fis;
		ServletOutputStream sos;
		
		try {
			fileName=detail.getFileName();
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
}
