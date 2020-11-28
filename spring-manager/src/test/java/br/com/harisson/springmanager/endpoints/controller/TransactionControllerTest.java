package br.com.harisson.springmanager.endpoints.controller;

import br.com.harisson.coreproject.model.Transaction;
import br.com.harisson.springmanager.endpoints.service.ApplicationUserService;
import br.com.harisson.springmanager.endpoints.service.TransactionService;
import br.com.harisson.springmanager.endpoints.util.ApplicationUserCreator;
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
import static org.springframework.http.HttpStatus.FORBIDDEN;

@ExtendWith(SpringExtension.class)
class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionServiceMock;

    @Mock
    private ApplicationUserService applicationUserService;

    @BeforeEach
    public void setUp() {
        BDDMockito.when(transactionServiceMock.listTransactionsByUserKey(anyString()))
                .thenReturn(List.of(TransactionCreator.createValidTransaction()));

        BDDMockito.when(applicationUserService.applicationUserLoggedNow())
                .thenReturn(ApplicationUserCreator.createValidApplicationUser());
    }

    @Test
    @DisplayName("List all user transactions when successful")
    void listAllUserTransactions_WhenSuccessful() {

        String expectedId = TransactionCreator.createValidTransaction().getId();

        List<Transaction> transactionList = transactionController.findTransactionsByAccountId(1L).getBody();

        Assertions.assertThat(transactionList).isNotNull();

        Assertions.assertThat(transactionList.get(0).getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("List all user transactions when forbidden response")
    void listAllUserTransactions_WhenForbiddenResponse() {

        Assertions.assertThat(transactionController.findTransactionsByAccountId(2L).getStatusCode())
                .isEqualTo(FORBIDDEN);

    }
}
