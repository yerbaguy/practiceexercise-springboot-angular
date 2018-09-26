package com.ebartmedia.practiceexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebartmedia.practiceexercise.model.EngWord;

public interface EngwordRepository extends JpaRepository<EngWord, Integer> {
	
//	@Modifying
//	@Transactional
//    @Query("UPDATE RandPl r SET r.randPlWord= :randPlWord WHERE r.id=1")
//	void updIdAndRandPl(@Param("randPlWord") int randPlWord);
	
	@Modifying
	@Transactional
	@Query("UPDATE EngWord r SET r.typedengword= :engword WHERE r.id=1")
	void updengword(@Param("engword") String engword);
	
//	@Query("SELECT e.typedengword FROM EngWord e WHERE e.id = 1")
//	public String findTypedEngword();
	
	@Query("SELECT e.typedengword FROM EngWord e WHERE e.id = 1")
	public String findTypedEngword();

}
