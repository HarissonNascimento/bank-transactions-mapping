package br.com.harisson.coreproject.repository;

import br.com.harisson.coreproject.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findTransactionByUserKey(String userKey);
}
