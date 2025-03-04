package com.archer.monolithic.Trivia.Service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.archer.monolithic.Trivia.DAO.QuestionDAO;
import com.archer.monolithic.Trivia.Model.Questions;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questionDAO;

	// 1. Find All
	public ResponseEntity<List<Questions>>  getAllQuestions() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<> (questionDAO.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<> (new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	
	// 2. Filter By Category
	public ResponseEntity<List<Questions>> findByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<> (questionDAO.findByCategory(category), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<> (new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

	// 3. Add Questions
	public ResponseEntity<String> addQuestion(Questions question) {
		// TODO Auto-generated method stub
		try {
		questionDAO.save(question);
		return new ResponseEntity<> ("Successfull", HttpStatus.CREATED);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<> ("Not A Successfull", HttpStatus.BAD_REQUEST);
	}

	//4. Delete Question
	public void deleteQuestion(Integer id) throws Exception {
		// TODO Auto-generated method stub
		// Check if the question exists; throw an exception if not.
        if (!questionDAO.existsById(id)) {
            throw new Exception("Question not found with id: " + id);
        }
        questionDAO.deleteById(id);
	}
	

}
