package org.iqpizza.advancedpost.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.iqpizza.advancedpost.user.constant.MemberShip;
import org.iqpizza.advancedpost.user.constant.RegisterType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@Entity(name = "users")
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegisterType registerType = RegisterType.NORMAL;

    @Builder.Default
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberShip memberShip = MemberShip.NONE;

    @Builder.Default
    @Column(nullable = false)
    private boolean verify = false;

    @Builder.Default
    @Column(nullable = false)
    private short incorrectPassword = 0;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(memberShip.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return (incorrectPassword >= 5);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return verify;
    }
}
