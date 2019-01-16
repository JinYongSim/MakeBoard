package com.scit.MakeBoard;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.scit.MakeBoard.VO.Board;

@Controller
public class FileController {
	
	private static final String UPLOADPATH="C:\\Users\\SIM\\upload\\";
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public String fileUpload(MultipartFile uploadFile) {
		String fileName=uploadFile.getOriginalFilename();
		System.out.println("11");
		
		try {
			uploadFile.transferTo(new File(UPLOADPATH+fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/insertBoard";
	}
}
