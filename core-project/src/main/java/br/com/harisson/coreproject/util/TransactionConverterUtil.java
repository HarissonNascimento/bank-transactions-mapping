package br.com.harisson.coreproject.util;

import br.com.harisson.coreproject.model.Transaction;

public class TransactionConverterUtil {

    private TransactionConverterUtil() {
    }

    public static Transaction convertJsonTransactionReceiverToTransaction(JsonTransactionReceiverUtil jsonReceiver) {
        return Transaction.builder()
                .id(jsonReceiver.getEncodedKey())
                .arrangementId(jsonReceiver.getParentAccountKey())
                .bookingDate(jsonReceiver.getCreationDate())
                .type(jsonReceiver.getType())
                .valueDate(jsonReceiver.getValueDate())
                .amount(jsonReceiver.getAmount())
                .currencyCode(jsonReceiver.getCurrencyCode())
                .currency(jsonReceiver.getCurrencyCode())
                .creditDebitIndicator(creditDebitIndicator(jsonReceiver.getAmount()))
                .runningBalance(jsonReceiver.getAccountBalances().getTotalBalance())
                .counterPartyAccountNumber(jsonReceiver.getId())
                .reference(jsonReceiver.getParentAccountKey())
                .typeGroup(jsonReceiver.getType())
                .instructedAmount(jsonReceiver.getAmount())
                .userKey(jsonReceiver.getUserKey())
                .build();
    }

    private static String creditDebitIndicator(Double amount) {
        if (amount < 0) {
            return "DEBIT";
        }
        return "CREDIT";
    }

}
