package com.archer.monolithic.Trivia.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.archer.monolithic.Trivia.DAO.QuestionDAO;
import com.archer.monolithic.Trivia.DAO.TriviaDao;
import com.archer.monolithic.Trivia.Model.QuestionWrapper;
import com.archer.monolithic.Trivia.Model.Questions;
import com.archer.monolithic.Trivia.Model.Response;
import com.archer.monolithic.Trivia.Model.Trivia;

@Service
public class TriviaService {

	@Autowired
	TriviaDao triviaDao;
	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createTrivia(String category, int numOfQuestions, String title) {
		// TODO Auto-generated method stub
		
		List<Questions> que = questionDAO.findRandoomQuestionsByCategory(category, numOfQuestions);
 		
		Trivia trivia = new Trivia();
		trivia.setTitle(title);
		trivia.setQuestions(que);
		triviaDao.save(trivia);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getTriviaQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Trivia> triv=triviaDao.findById(id);
		List<Questions> quesFromDB = triv.get().getQuestions();
		List<QuestionWrapper> quesForUser = new ArrayList<QuestionWrapper>();
		for(Questions q : quesFromDB ) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			quesForUser.add(qw);
		}
		
		return null;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Trivia trivia = triviaDao.findById(id).get();
		
		List<Questions> ques= trivia.getQuestions();
		int right=0;
		int i=0;
		for(Response res: responses) {
		
		}
		return null;
	}
}
