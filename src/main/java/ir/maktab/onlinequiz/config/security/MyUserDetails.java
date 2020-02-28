package ir.maktab.onlinequiz.config.security;

import ir.maktab.java32.projects.onlineexamsmanagement.modules.usermanagement.features.accountmanagement.adapter.persistance.entities.AccountJpaEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public MyUserDetails(AccountJpaEntity account) {
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.active = account.isActive();

        account.getRoles()
                .forEach(
                        roleJpaEntity -> {
                            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleJpaEntity.getRoleType().toString());
                            authorities.add(grantedAuthority);
                        }
                );

        account.getRoles()
                .stream()
                .flatMap(roleJpaEntity -> roleJpaEntity.getPrivileges().stream())
                .forEach(
                        privilegeJpaEntity -> {
                            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(privilegeJpaEntity.getPrivilegeTypes().toString());
                            authorities.add(grantedAuthority);
                        }
                );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
