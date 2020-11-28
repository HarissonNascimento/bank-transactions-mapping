package br.com.harisson.springmanager.endpoints.util;

import br.com.harisson.coreproject.model.ApplicationUser;
import br.com.harisson.coreproject.model.Transaction;
import br.com.harisson.coreproject.util.JsonTransactionReceiverUtil;
import br.com.harisson.coreproject.util.TransactionConverterUtil;
import br.com.harisson.springmanager.endpoints.service.ApplicationUserService;
import br.com.harisson.springmanager.endpoints.service.TransactionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class JsonTransactionMapperUtil {

    private JsonTransactionMapperUtil() {
    }

    public static void createTransactionListWithJsonArchive(TransactionService transactionService) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<JsonTransactionReceiverUtil>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/transactions.json");
        mapperJsonTransaction(mapper, inputStream, typeReference, transactionService);
    }

    private static void mapperJsonTransaction(ObjectMapper objectMapper, InputStream inputStream, TypeReference<List<JsonTransactionReceiverUtil>> typeReference, TransactionService transactionService) {
        try {
            List<JsonTransactionReceiverUtil> jsonTransactionsList = objectMapper.readValue(inputStream, typeReference);
            transactionService.saveTransactionList(convertJsonListInTransactionList(jsonTransactionsList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Transaction> convertJsonListInTransactionList(List<JsonTransactionReceiverUtil> jsonTransactionList) {
        return jsonTransactionList.stream()
                .map(TransactionConverterUtil::convertJsonTransactionReceiverToTransaction)
                .collect(Collectors.toList());
    }

    public static void createApplicationUserListWithJsonArchive(ApplicationUserService applicationUserService) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ApplicationUser>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/setup-users.json");
        mapperJsonApplicationUser(mapper, inputStream, typeReference, applicationUserService);
    }

    private static void mapperJsonApplicationUser(ObjectMapper objectMapper, InputStream inputStream, TypeReference<List<ApplicationUser>> typeReference, ApplicationUserService applicationUserService) {
        try {
            List<ApplicationUser> jsonApplicationUsersList = objectMapper.readValue(inputStream, typeReference);
            applicationUserService.saveApplicationUserList(jsonApplicationUsersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
