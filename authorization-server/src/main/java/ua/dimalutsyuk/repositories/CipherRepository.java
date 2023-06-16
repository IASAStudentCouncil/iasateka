package ua.dimalutsyuk.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.dimalutsyuk.models.Cipher;

import java.util.Optional;

public interface CipherRepository extends MongoRepository<Cipher, Integer> {
    Optional<Cipher> findByCipher(String cipher);
}
