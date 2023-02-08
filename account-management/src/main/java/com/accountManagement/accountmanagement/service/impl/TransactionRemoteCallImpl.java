package com.accountManagement.accountmanagement.service.impl;

import com.accountManagement.accountmanagement.constant.ApiConstant;
import com.accountManagement.accountmanagement.dto.AccountTransactionDto;
import com.accountManagement.accountmanagement.exception.AddTransactionException;
import com.accountManagement.accountmanagement.exception.GetTransactionException;
import com.accountManagement.accountmanagement.service.TransactionRemoteCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class TransactionRemoteCallImpl implements TransactionRemoteCall {

    private final WebClient webClient;
    private String transactionServiceBaseURL;


    public TransactionRemoteCallImpl(@Value("${services.transaction.baseurl}") String transactionServiceBaseURL){
        this.transactionServiceBaseURL = transactionServiceBaseURL;
        this.webClient = WebClient.create(transactionServiceBaseURL);
    }
    public List<AccountTransactionDto> getTransactionById(List<Long> accountId){

        log.debug("Connected to : {}",transactionServiceBaseURL);
        log.debug("getting transaction by accountId : {}",accountId);
        return webClient.post()
                .uri(ApiConstant.TRANSACTION_MANAGEMENT_MAPPING+ApiConstant.GET_TRANSACTION_MAPPING)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(accountId))
                .retrieve()
                .onStatus(HttpStatus::isError, cr -> Mono.error(GetTransactionException::new))
                .bodyToMono(new ParameterizedTypeReference<List<AccountTransactionDto>>() {})
                .block();
    }

    public void addTransaction(Long accountId, double amount){

        log.debug("Adding transaction for accountId : {}",accountId);
        Map<String, String> bodyValues = new HashMap<>();

        bodyValues.put("accountId", String.valueOf(accountId));
        bodyValues.put("amount", String.valueOf(amount));
        webClient.post()
                .uri(ApiConstant.TRANSACTION_MANAGEMENT_MAPPING+ApiConstant.CREATE_TRANSACTION_MAPPING)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .retrieve()
                .onStatus(HttpStatus::isError, cr -> Mono.error(AddTransactionException::new))
                .bodyToMono(Void.class)
                .block();

    }

}
