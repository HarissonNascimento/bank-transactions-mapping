package br.com.harisson.springmanager.endpoints.service;

import br.com.harisson.coreproject.model.ApplicationUser;
import br.com.harisson.coreproject.repository.ApplicationUserRepository;
import br.com.harisson.springmanager.endpoints.util.ApplicationUserCreator;
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
class ApplicationUserServiceTest {
    @InjectMocks
    private ApplicationUserService applicationUserService;

    @Mock
    private ApplicationUserRepository applicationUserRepository;

    @BeforeEach
    public void setUp() {

        BDDMockito.when(applicationUserRepository.findByUsername(anyString()))
                .thenReturn(ApplicationUserCreator.createValidApplicationUser());

    }

    @Test
    @DisplayName("saveList returns this when successful")
    void saveList_ReturnsThis_WhenSuccessful() {
        List<ApplicationUser> list = List.of(ApplicationUserCreator.createValidApplicationUser());

        Assertions.assertThatCode(() -> applicationUserService.saveApplicationUserList(list))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("findByUsername returns ApplicationUser when sucessful")
    void findByUsername_ReturnsApplicationUser_WhenSucessful() {
        String expectedUsername = ApplicationUserCreator.createValidApplicationUser().getUsername();

        ApplicationUser applicationUser = applicationUserService.findByUsername(expectedUsername);

        Assertions.assertThat(applicationUser).isNotNull();

        Assertions.assertThat(applicationUser.getUsername()).isNotNull();

        Assertions.assertThat(applicationUser.getUsername()).isEqualTo(expectedUsername);
    }
}
