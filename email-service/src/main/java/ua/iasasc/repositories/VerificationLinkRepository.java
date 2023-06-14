package ua.iasasc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.iasasc.models.VerificationLink;

import java.util.Optional;

public interface VerificationLinkRepository extends MongoRepository<VerificationLink, Integer> {
    Optional<VerificationLink> findByCipher(String cipher);
}
