package com.tech.prjm09.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.prjm09.util.CryptoUtil;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EncryptController {
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
		return "/encrypt/ecryptlogin";
	}
	
	@RequestMapping("/encryptlogin")
	public String encryptlogin(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// 복호화
		String decPass = "";
		try {
			decPass = CryptoUtil.decryptAES256(bcpwd, shapwd);
			System.out.println("decPass : "+decPass);
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
