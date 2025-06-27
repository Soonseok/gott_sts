package com.tech.prjm09.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.prjm09.dao.EncryptIDao;
import com.tech.prjm09.dto.CMember;
import com.tech.prjm09.util.CryptoUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EncryptController {
	
	@Autowired
	private EncryptIDao encryptIDao;
	
	String shapwd;
	String bcpwd;
	
	@RequestMapping("/ecryptform")
	public String ecryptform() {
		return "/encrypt/ecryptform";
	}
	
	@RequestMapping("/encryptjoin")
	public String encryptjoin(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// 암호화
		try {
			shapwd = CryptoUtil.sha512(pass);
			bcpwd = CryptoUtil.encryptAES256(pass, shapwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("shapwd : "+shapwd);
		System.out.println("bcpwd : "+bcpwd);
		
		encryptIDao.join(id, pass, bcpwd, shapwd);
		
		return "/encrypt/ecryptlogin";
	}
	
	@RequestMapping("/encryptlogin")
	public String encryptlogin(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// 복호화
		String decPass = "";
		CMember cm = encryptIDao.getMember(id);
		System.out.println(cm.getMid());
		System.out.println(cm.getMbcpwd());
		
		try {
			decPass = CryptoUtil.decryptAES256(cm.getMbcpwd(), cm.getMshpwd());
			System.out.println("DB에 있는 암호 : "+decPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(pass.equals(decPass)) {
			System.out.println("일치");
		}else {
			System.out.println("불일치");
		}
		
		return "/encrypt/ecryptlogin";
	}
	
}
