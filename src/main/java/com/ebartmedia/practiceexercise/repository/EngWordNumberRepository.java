package com.ebartmedia.practiceexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebartmedia.practiceexercise.model.EngWordNumber;


@Repository
public interface EngWordNumberRepository extends JpaRepository<EngWordNumber, Integer> {
	
	
	@Modifying
	@Transactional
    @Query("UPDATE EngWordNumber e SET e.engwordnumber= :getengwordnumber WHERE e.id=1")
	void updEngWordNumber(@Param("getengwordnumber") int getengwordnumber);
	
	@Query("SELECT e.engwordnumber FROM EngWordNumber e WHERE e.id = 1")
	public int findEngWordNumber();
	
	

}
