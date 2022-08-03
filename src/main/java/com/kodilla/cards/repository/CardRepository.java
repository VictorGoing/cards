package com.kodilla.cards.repository;

import com.kodilla.cards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByCustomerId(Long customerId);
}
