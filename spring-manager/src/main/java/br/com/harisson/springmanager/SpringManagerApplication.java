package br.com.harisson.springmanager;

import br.com.harisson.coreproject.property.JwtConfiguration;
import br.com.harisson.springmanager.endpoints.service.ApplicationUserService;
import br.com.harisson.springmanager.endpoints.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static br.com.harisson.springmanager.endpoints.util.JsonTransactionMapperUtil.createApplicationUserListWithJsonArchive;
import static br.com.harisson.springmanager.endpoints.util.JsonTransactionMapperUtil.createTransactionListWithJsonArchive;

@SpringBootApplication
@EntityScan({"br.com.harisson.coreproject.model"})
@EnableJpaRepositories({"br.com.harisson.coreproject.repository"})
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan({"br.com.harisson"})
public class SpringManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runnerTransaction(TransactionService transactionService) {
        return args -> createTransactionListWithJsonArchive(transactionService);
    }

    @Bean
    CommandLineRunner runnerApplicationUser(ApplicationUserService applicationUserService) {
        return args -> createApplicationUserListWithJsonArchive(applicationUserService);
    }

}
