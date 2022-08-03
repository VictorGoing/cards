package com.kodilla.cards.mapper;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardMapper {

    public Card mapToCard(CardDto cardDto) {
        return new Card(
                cardDto.getId(),
                cardDto.getCustomerId(),
                cardDto.getNumber(),
                cardDto.getExpirationDate(),
                cardDto.getSecurityCode()
        );
    }

    public CardDto mapToCardDto(Card card) {
        return new CardDto(
                card.getId(),
                card.getCustomerId(),
                card.getNumber(),
                card.getExpirationDate(),
                card.getSecurityCode()
        );
    }

    public List<CardDto> mapToCardDtoList(List<Card> list) {
        return list.stream()
                .map(this::mapToCardDto)
                .collect(Collectors.toList());
    }
}
