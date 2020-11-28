package br.com.harisson.springmanager.endpoints.service;

import br.com.harisson.coreproject.model.ApplicationUser;
import br.com.harisson.coreproject.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class ApplicationUserService {
    private final ApplicationUserRepository applicationUserRepository;

    public void saveApplicationUserList(List<ApplicationUser> applicationUsers){
        applicationUserRepository.saveAll(applicationUsers);
    }

    public ApplicationUser findByUsername(String username){
        return applicationUserRepository.findByUsername(username);
    }

    public ApplicationUser applicationUserLoggedNow(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ApplicationUser userLogged = (ApplicationUser) authentication.getPrincipal();
        return findByUsername(userLogged.getUsername());
    }
}
