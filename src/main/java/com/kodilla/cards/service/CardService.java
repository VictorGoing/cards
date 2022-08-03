package com.kodilla.cards.service;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card saveCard(Card card) {return cardRepository.save(card);}

    public List<Card> getCardByCustomerId(Long customerId){
        return cardRepository.findAllByCustomerId(customerId);
    }
}
