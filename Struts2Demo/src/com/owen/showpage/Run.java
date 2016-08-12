package com.owen.showpage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Run {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, ClassNotFoundException, IOException{
		LoadCommentData lcd = new LoadCommentData();
		String url = "http://blog.sciencenet.cn/blog-814548-977887.html";
		List<CommentData> listCommentsData = lcd.generateCommentData(url);
		for(CommentData cd :listCommentsData){
			System.out.println(cd.comment+"...."+cd.sentiment+"\n");
		}
	}
}
