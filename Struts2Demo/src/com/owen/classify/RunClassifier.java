package com.owen.classify;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.BaseClassifier;
import com.aliasi.classify.Classification;
import com.aliasi.util.AbstractExternalizable;

public class RunClassifier {
	 String classifierPath ;
	 BaseClassifier<CharSequence> classifier;
	
	//构造函数
	public RunClassifier() {
		String url = this.getClass().getResource("").getPath().replaceAll("%20", " ");    //mark ！！！获取当前java文件的地址
		String path =  url.substring(0, url.indexOf("WEB-INF"))                           //然后读到subString WEB—INF的地址  然后加到想要的model处 
                + "WEB-INF/models/DynamicLM2.0";
		this.classifierPath =path; //"./DynamicLM2.0";
		File serializedClassifier = new File(classifierPath);
		System.out.println("Loading: " + classifierPath);
		try {
			this.classifier = (BaseClassifier<CharSequence>) AbstractExternalizable.readObject(serializedClassifier);
			System.out.println("LM加载完成，生成classifier");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  String classifyString(String s) throws ClassNotFoundException, IOException{
		Classification classified = classifier.classify(s);
//		System.out.println(classified.bestCategory());
		return classified.bestCategory();
	}

}
