package ua.dimalutsyuk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dimalutsyuk.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
