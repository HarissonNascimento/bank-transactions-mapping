package br.com.harisson.coreproject.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonTransactionReceiverUtil {

    private String encodedKey;
    private String parentAccountKey;
    private String creationDate;
    private String type;
    private String valueDate;
    private Double amount;
    private String currencyCode;
    private String creditDebitIndicator;
    private String id;
    private String userKey;
    @Embedded
    private TotalBalanceUtil accountBalances;

}
