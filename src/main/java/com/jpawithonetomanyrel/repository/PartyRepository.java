package com.jpawithonetomanyrel.repository;

import com.jpawithonetomanyrel.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PartyRepository extends CrudRepository<Party, Long> {
}