package com.ebartmedia.practiceexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ebartmedia.practiceexercise.model.Words;


@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {
	
	@Query("SELECT COUNT(w) FROM Words w")
	public int countWord();

//	@Query("SELECT w.plword FROM Words w WHERE id= :randplword")
//	public String findWord(@Param("randplword") int randplword);

//	@Query("SELECT w FROM Words w WHERE w.plword LIKE ?1")
//	public String findWord(@Param("n1") int n1);

//	@Query("SELECT w.plword FROM Words w WHERE w.id = 1")
//	public String findWord();
	
//	@Query("SELECT w.plword FROM Words w WHERE w.id = n1")
//	@Query("SELECT w.plword FROM Words w WHERE w.id LIKE ?1") //here 
	@Query("SELECT w.plword FROM Words w WHERE w.id= :countrandom")
	
//	@Query("SELECT w.plword FROM Words w WHERE id= :n1")
//	@Query("SELECT w.plword FROM Words w WHERE w.id= :n1")
	public String getWord(@Param("countrandom")int countrandom);
	
//	@Query("SELECT w.plword FROM Words w WHERE id= :n1")
//	public String getWord(@Param("n1") int n1);
	
	@Query("SELECT w.id FROM Words w WHERE w.engword= :engword")
	public int getWordNumber(@Param("engword") String engword);
}
