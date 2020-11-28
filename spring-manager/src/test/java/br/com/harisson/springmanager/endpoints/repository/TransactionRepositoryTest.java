package br.com.harisson.springmanager.endpoints.repository;

import br.com.harisson.coreproject.model.Transaction;
import br.com.harisson.coreproject.repository.TransactionRepository;
import br.com.harisson.springmanager.endpoints.util.TransactionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("Transaction Repository Tests")
class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    @DisplayName("Save create transaction when successful")
    void save_PersistTransaction_WhenSuccessful(){
        Transaction transaction = TransactionCreator.createValidTransaction();

        Transaction savedTransaction = this.transactionRepository.save(transaction);

        Assertions.assertThat(savedTransaction.getId()).isNotNull();
        Assertions.assertThat(savedTransaction.getArrangementId()).isEqualTo(transaction.getArrangementId());
        Assertions.assertThat(savedTransaction.getBookingDate()).isEqualTo(transaction.getBookingDate());
        Assertions.assertThat(savedTransaction.getType()).isEqualTo(transaction.getType());
        Assertions.assertThat(savedTransaction.getValueDate()).isEqualTo(transaction.getValueDate());
        Assertions.assertThat(savedTransaction.getAmount()).isEqualTo(transaction.getAmount());
        Assertions.assertThat(savedTransaction.getCurrencyCode()).isEqualTo(transaction.getCurrencyCode());
        Assertions.assertThat(savedTransaction.getCurrency()).isEqualTo(transaction.getCurrency());
        Assertions.assertThat(savedTransaction.getCreditDebitIndicator()).isEqualTo(transaction.getCreditDebitIndicator());
        Assertions.assertThat(savedTransaction.getRunningBalance()).isEqualTo(transaction.getRunningBalance());
        Assertions.assertThat(savedTransaction.getCounterPartyAccountNumber()).isEqualTo(transaction.getCounterPartyAccountNumber());
        Assertions.assertThat(savedTransaction.getReference()).isEqualTo(transaction.getReference());
        Assertions.assertThat(savedTransaction.getTypeGroup()).isEqualTo(transaction.getTypeGroup());
        Assertions.assertThat(savedTransaction.getInstructedAmount()).isEqualTo(transaction.getInstructedAmount());
        Assertions.assertThat(savedTransaction.getUserKey()).isEqualTo(transaction.getUserKey());

    }

    @Test
    @DisplayName("Find transaction by userKey return listTransactions when successful")
    void findTransactionsByUserKey_ReturnListTransactions_WhenSuccessful(){
        String expectedUserKey = TransactionCreator.createValidTransaction().getUserKey();

        List<Transaction> transactionList = transactionRepository.findTransactionByUserKey(expectedUserKey);

        Assertions.assertThat(transactionList).isNotNull();

        Assertions.assertThat(transactionList.isEmpty()).isFalse();

        Assertions.assertThat(transactionList.get(0).getUserKey()).isEqualTo(expectedUserKey);
    }
}
