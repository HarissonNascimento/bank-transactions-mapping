package br.com.harisson.springmanager.endpoints.repository;

import br.com.harisson.coreproject.model.ApplicationUser;
import br.com.harisson.coreproject.repository.ApplicationUserRepository;
import br.com.harisson.springmanager.endpoints.util.ApplicationUserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("ApplicationUser Repository Tests")
class ApplicationUserRepositoryTest {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Test
    @DisplayName("Save create applicationuser when successful")
    void save_PersistApplicationUser_WhenSuccessful() {
        ApplicationUser applicationUser = ApplicationUserCreator.createApplicationUserToBeSaved();

        ApplicationUser savedApplicationUser = applicationUserRepository.save(applicationUser);

        Assertions.assertThat(savedApplicationUser.getAccountId()).isNotNull();
        Assertions.assertThat(savedApplicationUser.getUsername()).isNotNull();
        Assertions.assertThat(savedApplicationUser.getUsername()).isEqualTo(applicationUser.getUsername());
        Assertions.assertThat(savedApplicationUser.getPassword()).isNotNull();
        Assertions.assertThat(savedApplicationUser.getPassword()).isEqualTo(applicationUser.getPassword());
        Assertions.assertThat(savedApplicationUser.getRole()).isNotNull();
        Assertions.assertThat(savedApplicationUser.getRole()).isEqualTo(applicationUser.getRole());
        Assertions.assertThat(savedApplicationUser.getUserKey()).isNotNull();
        Assertions.assertThat(savedApplicationUser.getUserKey()).isEqualTo(applicationUser.getUserKey());
    }

    @Test
    @DisplayName("Find by username return application user when successful")
    void findByUsername_ReturnApplicationUser_WhenSuccessful() {
        applicationUserRepository.save(ApplicationUserCreator.createValidApplicationUser());

        String expectedUsername = ApplicationUserCreator.createValidApplicationUser().getUsername();

        ApplicationUser applicationUser = applicationUserRepository.findByUsername(expectedUsername);

        Assertions.assertThat(applicationUser).isNotNull();

        Assertions.assertThat(applicationUser.getUsername()).isEqualTo(expectedUsername);
    }
}
