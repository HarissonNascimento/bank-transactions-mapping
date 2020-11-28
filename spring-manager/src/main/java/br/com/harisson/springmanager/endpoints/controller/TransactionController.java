package br.com.harisson.springmanager.endpoints.controller;

import br.com.harisson.coreproject.model.ApplicationUser;
import br.com.harisson.coreproject.model.Transaction;
import br.com.harisson.springmanager.endpoints.service.ApplicationUserService;
import br.com.harisson.springmanager.endpoints.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionController {

    private final TransactionService transactionService;
    private final ApplicationUserService applicationUserService;

    @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> findTransactionsByAccountId(@PathVariable Long accountId) {
        ApplicationUser userNow = applicationUserService.applicationUserLoggedNow();
        return userNow.getAccountId().equals(accountId) ? ResponseEntity.ok(transactionService.listTransactionsByUserKey(userNow.getUserKey())) : new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
