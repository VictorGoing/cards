package com.kodilla.cards.controller;

import com.kodilla.cards.controller.response.GetCardsResponse;
import com.kodilla.cards.domain.Card;
import com.kodilla.cards.dto.CardDto;
import com.kodilla.cards.mapper.CardMapper;
import com.kodilla.cards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RefreshScope
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping
    public ResponseEntity<GetCardsResponse> getCardsByCustomerId(@RequestParam("customerId") Long customerId) {
        List<Card> cardList = cardService.getCardByCustomerId(customerId);
        List<CardDto> cardDtoList = cardMapper.mapToCardDtoList(cardList);
        return ResponseEntity.ok(new GetCardsResponse(cardDtoList));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCard(@RequestBody CardDto cardDto) {
        Card card = cardMapper.mapToCard(cardDto);
        cardService.saveCard(card);
        return ResponseEntity.ok().build();
    }
}
