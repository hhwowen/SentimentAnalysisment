package com.owen.runfirst;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.owen.classify.RunClassifier;

public class RunFirst implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//预先加载分类器
		System.out.println("======listener test is beginning=========");
		ServletContext context=sce.getServletContext();
		RunClassifier classifier = new RunClassifier();
		context.setAttribute("classifier",classifier);	
		System.out.println("======classifier load is finished=========");
	}

}
