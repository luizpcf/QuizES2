package br.ufmg.dcc.rs.quizes.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import br.ufmg.dcc.rs.quizes.model.Question;



public class LessonDatabase {

	public static LessonDatabase instance;
	
	public static LessonDatabase getInstance() {
		if (instance == null) {
			instance = new LessonDatabase();
		}
		return instance;
	}
	
	public static void setInstance(LessonDatabase questionDatabase)
	{
		instance=questionDatabase;
	}

	//private Map<String, List<Question>> questionsByCategory;
	
	public void getQuestionsByCategory() {
		
	}
	
	public List getAllQuestions() {
		List questions = new ArrayList();
		
		return questions;
	}
	

	public List getCategories(){
		 List categories =  new LinkedList();
		 //categories.addAll(questionsByCategory.keySet());
		 Collections.sort(categories);
		 return categories;
	}

	
}