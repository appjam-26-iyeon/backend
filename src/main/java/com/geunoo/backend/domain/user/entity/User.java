package com.geunoo.backend.domain.user.entity;

import com.gil.easyjwt.user.JwtUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends JwtUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String accountId;

    @NotNull
    @Column(columnDefinition = "CHAR(60)")
    private String password;

    @NotNull
    @Column(columnDefinition = "VARCHAR(60)")
    private String name;

    @Column(columnDefinition = "VARCHAR(255)")
    private String profileImage;

    @NotNull
    @Column(columnDefinition = "DATE")
    private Date birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couple_id")
    private User couple;

    @Builder
    public User(String accountId, String password, String name, String profileImage, Date birthday, User user) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.profileImage = profileImage;
        this.birthday = birthday;
        this.couple = user;
    }

    @Override
    public String getUsername() {
        return getAccountId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public void updateCouple(User user) {
        this.couple = user;
    }
}
