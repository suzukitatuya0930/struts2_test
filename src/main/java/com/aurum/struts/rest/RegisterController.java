package com.aurum.struts.rest;

import java.util.List;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.aurum.struts.model.Register;
import com.aurum.struts.repository.RegisterRepository;

public class RegisterController  {
	
	private String name;
	
	 private RegisterRepository registerRepository;

	    public RegisterController() {
	        this.registerRepository = new RegisterRepository();
	    }

	    public  HttpHeaders create() {
	        registerRepository.register(name);
	        return new DefaultHttpHeaders("create");
	    }
	    
	   
//	    public HttpHeaders index() {
//	    	
//	    	registerRepository.findAll();
//			
//			return new DefaultHttpHeaders("index");
//		}
	    
	    
	    public HttpHeaders index() {
	        List<Register> registerList = registerRepository.findAll();
	        
	        for (Register register : registerList) {
	            String name = register.getName();
	            // 取得したnameを適切な処理で利用する（例: ログに出力する）
	            System.out.println("Name: " + name);
	        }
	      
	        return new DefaultHttpHeaders("index");
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    
	    
//	    public HttpHeaders index() {
//			users = repository.findAll();
//			System.out.println("GET \t /user");
//			return new DefaultHttpHeaders("index");
//		}
}


