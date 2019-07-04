package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean send(
			String to, String subject, String text, MultipartFile file)
	{
		boolean flag=false;
		try {
			//1.create MimeMessage Object
			MimeMessage message=mailSender.createMimeMessage();
			
			//2.Helper class Object
			MimeMessageHelper helper=new MimeMessageHelper(message, file!=null?true:false);
			
			//3.setDetails
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			
			if(file!=null)
			helper.addAttachment(file.getOriginalFilename(), file);
			
			//send button
			mailSender.send(message);
			
			flag= true;
		} catch (Exception e) {
			flag= false;
			e.printStackTrace();
		}
		
		return false;
		
	}
}
