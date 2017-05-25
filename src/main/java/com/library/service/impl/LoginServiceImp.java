package com.library.service.impl;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Service;

import com.library.model.User;
import com.library.model.dao.UserDAO;
import com.library.service.LoginService;
import com.library.vo.LoginRequest;
import com.library.vo.Loginresponse;
@Service
public class LoginServiceImp extends BaseServiceImpl implements LoginService {
	@Autowired
	UserDAO userDao;

	@Override
	public Loginresponse loginrequest(LoginRequest loginRequest) {
		User user=userDao.getByemailid(loginRequest.getEmail());
		if(user.getPassword().equals(loginRequest.getPassword())){
			
			String Token=randomString(10);
			
			Loginresponse loginresponse=new Loginresponse();
			loginresponse.setUser(user);
			loginresponse.setToken(Token);
			
			return loginresponse;
		}
		else {
			return null;
		}
		
		// TODO Auto-generated method stub
		
	}
	
	


static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
static SecureRandom rnd = new SecureRandom();

String randomString( int len ){
   StringBuilder sb = new StringBuilder( len );
   for( int i = 0; i < len; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
   return sb.toString();
}



}
