package br.com.harisson.springmanager.endpoints.service;

import br.com.harisson.coreproject.model.Transaction;
import br.com.harisson.coreproject.repository.TransactionRepository;
import br.com.harisson.springmanager.endpoints.util.TransactionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {

        BDDMockito.when(transactionRepository.findTransactionByUserKey(anyString()))
                .thenReturn(List.of(TransactionCreator.createValidTransaction()));

    }

    @Test
    @DisplayName("saveList returns this when successful")
    void saveList_ReturnsThis_WhenSuccessful() {
        List<Transaction> list = List.of(TransactionCreator.createValidTransaction());

        Assertions.assertThatCode(() -> transactionService.saveTransactionList(list))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Find transaction by userKey returns listTransactions when successful")
    void findTransactionByUserKey_ReturnsListTransactions_WhenSuccessful() {
        String expectedUserKey = TransactionCreator.createValidTransaction().getUserKey();

        List<Transaction> transactionList = transactionService.listTransactionsByUserKey(expectedUserKey);

        Assertions.assertThat(transactionList).isNotNull();

        Assertions.assertThat(transactionList.isEmpty()).isFalse();

        Assertions.assertThat(transactionList.get(0).getUserKey()).isEqualTo(expectedUserKey);
    }
}
