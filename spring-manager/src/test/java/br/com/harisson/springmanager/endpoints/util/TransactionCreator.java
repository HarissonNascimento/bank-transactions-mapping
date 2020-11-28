package br.com.harisson.springmanager.endpoints.util;

import br.com.harisson.coreproject.model.Transaction;

public class TransactionCreator {
    public static Transaction createValidTransaction(){
        return Transaction.builder()
                .id("8a85866f7155205601715987552476ec")
                .arrangementId("8a8587506b566dfd016b5add799444ec")
                .bookingDate("2020-04-08T15:08:49+02:00")
                .type("TRANSFER")
                .valueDate("2020-04-08T15:08:49+02:00")
                .amount(-12.5)
                .currencyCode("EUR")
                .currency("EUR")
                .creditDebitIndicator("DEBIT")
                .runningBalance(1587.5)
                .counterPartyAccountNumber("1205")
                .reference("8a8587506b566dfd016b5add799444ec")
                .typeGroup("TRANSFER")
                .instructedAmount(-12.5)
                .userKey("8a85867e6ad9e761016ada958bdf5b0f")
                .build();
    }
}
