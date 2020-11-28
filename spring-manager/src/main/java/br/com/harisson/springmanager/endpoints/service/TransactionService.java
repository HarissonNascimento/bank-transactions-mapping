package br.com.harisson.springmanager.endpoints.service;

import br.com.harisson.coreproject.model.Transaction;
import br.com.harisson.coreproject.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public void saveTransactionList(List<Transaction> transactionList) {
        transactionRepository.saveAll(transactionList);
    }

    public List<Transaction> listTransactionsByUserKey(String userKey){
        return transactionRepository.findTransactionByUserKey(userKey);
    }
}
