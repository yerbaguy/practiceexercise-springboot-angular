package com.ebartmedia.practiceexercise.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebartmedia.practiceexercise.model.RandPl;

public interface RandPlRepository extends JpaRepository<RandPl, Integer> {

//	int save()
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM RandPl")
	public void deleteRandPl();
	
//	@Modifying
//	@Transactional
//	@Query(value = "ALTER TABLE RandPl auto_increment=?1", nativeQuery = true)
	@Query(value = "ALTER RandPl r auto_increment=?1", nativeQuery = true)
	public void alterRandPl();
	
	@Query("SELECT r FROM RandPl r")
	public int idAndRandPl();
	
//	@Query("SELECT r FROM RandPl r")
//	public List<RandPl> findIdAndRandPl();
	
	@Query("SELECT r FROM RandPl r")
	public ArrayList<RandPl> findIdAndRandPl();
	
	@Modifying
	@Transactional
    @Query("UPDATE RandPl r SET r.randPlWord= :randPlWord WHERE r.id=1")
	void updIdAndRandPl(@Param("randPlWord") int randPlWord);
	
	@Query("SELECT r.randPlWord FROM RandPl r WHERE r.id = 1")
	public int findRandPlWord();
	
	
	
}
