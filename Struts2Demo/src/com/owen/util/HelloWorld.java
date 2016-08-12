package com.owen.util;

import java.text.DateFormat;
import java.util.Date;

import com.opensymphony.xwork2.Action;

public class HelloWorld implements Action {  
	  
    private String message;  
      
      
    /**  
     * @return the message  
     */  
    public String getMessage() {  
        return message;  
    }  
  
  
    /* (non-Javadoc)  
     * @see com.opensymphony.xwork2.Action#execute()  
     */  
    public String execute() throws Exception {  
        // TODO Auto-generated method stub  
        message = DateFormat.getInstance().format(new Date());  
        return SUCCESS;  
    }  
  
} 
