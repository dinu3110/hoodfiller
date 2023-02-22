package com.helpingsanta.hoodfiller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpingsanta.hoodfiller.model.Presents;

public interface PresentsRepository extends JpaRepository<Presents, Integer> {

	/**
	 * @param hoodedFlag
	 * @return
	 */
	List<Presents> findAllByHoodedFlag(boolean hoodedFlag);

}
