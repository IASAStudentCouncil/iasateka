package ua.dimalutsyuk.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.dimalutsyuk.models.Credentials;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
    @EntityGraph(attributePaths = "role")
    Optional<Credentials> findByEmail(String email);
}
