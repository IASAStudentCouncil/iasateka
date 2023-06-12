package ua.dimalutsyuk.models.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import ua.dimalutsyuk.models.Role;

@RequiredArgsConstructor
public class GrantedAuthorityAdapter implements GrantedAuthority {
    private final Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }
}
