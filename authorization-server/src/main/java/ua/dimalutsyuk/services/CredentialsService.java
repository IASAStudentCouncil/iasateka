package ua.dimalutsyuk.services;

import ua.dimalutsyuk.models.Credentials;

public interface CredentialsService {
    Credentials findByEmail(String email);

    void saveCredentials(Credentials credentials);
}
