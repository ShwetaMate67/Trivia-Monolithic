package com.archer.monolithic.Trivia.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.archer.monolithic.Trivia.Model.Questions;

@Repository
public interface QuestionDAO extends JpaRepository<Questions, Integer>{
	
	//Parameter that we are passing in the method should match the column in a table
	
	List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM Questions q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numOfQuestions", nativeQuery = true)
	List<Questions> findRandoomQuestionsByCategory(String category, int numOfQuestions);


}
