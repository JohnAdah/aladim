package com.trader.smarttrade.Entities;

import com.sun.istack.NotNull;
import com.trader.smarttrade.Enums.Gender;
import com.trader.smarttrade.Enums.IdentityType;
import com.trader.smarttrade.Enums.Roles;
import com.trader.smarttrade.Utils.IdGenerator;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name",length = 20, nullable = false, unique = true)
    private String userName;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 20, nullable = false)
    private String lastName;

    @Column(name = "email",length = 40, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(name = "date_of_registration")
    @CreationTimestamp()
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;

    @Column(name = "phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "identification_type", length = 40, nullable = false)
    private IdentityType idType;

    @Column(name = "identification_number", length = 25, nullable = false, unique = true)
    private Long idNumber;

    @Embedded
    private Address homeAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<UserRequest> requests;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private Merchants merchant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "wallet_id")
    private Wallet wallet;

    //By default, creating a new user should also generate a wallet id and set the
    // initial amount in the wallet to Zero.

    public Users(){
        String prefix = "USR";
        this.userId = IdGenerator.customIdGenerator(prefix,100,200);
        this.wallet = new Wallet();
    }
}
