package com.owen.classify;

import java.io.IOException;

import com.owen.classify.RunClassifier;

public class Run {
	//测试classifier用
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		String s = "好 ";
		RunClassifier c = new RunClassifier();
		System.out.println(c.classifyString(s));
		//c.classify(s);		
	}
}
