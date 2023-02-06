package com.accountManagement.accountmanagement.service.impl;

import com.accountManagement.accountmanagement.dto.AccountTransactionDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionRemoteCall {

    WebClient webClient = WebClient.create("http://localhost:8082");

    public List<AccountTransactionDto> getTransactionById(List<Long> accountId){

        return webClient.post()
                .uri("api/transaction-management/get-transaction")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(accountId))
                .retrieve()
                .onStatus(HttpStatus::isError, cr -> Mono.error(RuntimeException::new))
                .bodyToMono(new ParameterizedTypeReference<List<AccountTransactionDto>>() {})
                .block();
    }

    public void addTransaction(Long accountId, double amount){
        Map<String, String> bodyValues = new HashMap<>();

        bodyValues.put("accountId", String.valueOf(accountId));
        bodyValues.put("amount", String.valueOf(amount));
        webClient.post()
                .uri("api/transaction-management/create-transaction")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .retrieve()
                .onStatus(HttpStatus::isError, cr -> Mono.error(RuntimeException::new))
                .bodyToMono(Void.class)
                .block();

    }

}
