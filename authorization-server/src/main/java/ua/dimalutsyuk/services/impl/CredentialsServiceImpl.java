package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.models.Credentials;
import ua.dimalutsyuk.repositories.CredentialsRepository;
import ua.dimalutsyuk.services.CredentialsService;

@Service
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {
    private final CredentialsRepository repository;

    @Override
    public Credentials findByEmail(String email) {
        return repository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Credentials with this username does not exist in the database"));
    }

    @Override
    public void saveCredentials(Credentials credentials) {
        repository.save(credentials);
    }

    @Override
    public void setEmailToVerified(String email) {
        Credentials credentials = findByEmail(email);
        credentials.setEmailVerified(true);
        saveCredentials(credentials);
    }
}
