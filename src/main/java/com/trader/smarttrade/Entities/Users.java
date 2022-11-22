package com.trader.smarttrade.Entities;

import com.trader.smarttrade.Enums.IdentityType;
import com.trader.smarttrade.Enums.UserRole;
import com.trader.smarttrade.Utils.IdGenerator;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "first_name",  nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password",  nullable = false)
    private String password;

    @Column(name = "date_of_registration")
    @CreationTimestamp()
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;

    @Column(name = "phone_number",  nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "identification_type",  nullable = false)
    private IdentityType idType;

    @Column(name = "identification_number",  nullable = false, unique = true)
    private Long idNumber;

    @Embedded
    private Address homeAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<UserRequest> requests;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private List<MerchantResponse> responses;

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

    public Users(Wallet wallet) {
        this.wallet = wallet;
    }

//    @Override
//    public String toString() {
//        return "Users{" +
//                "userId='" + userId + '\'' +
//                ", userName='" + userName + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", dateOfRegistration=" + dateOfRegistration +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", idType=" + idType +
//                ", idNumber=" + idNumber +
//                //", homeAddress=" + homeAddress +
//                ", role=" + role +
//                ", requests=" + requests +
//                ", responses=" + responses +
//                ", wallet=" + wallet +
//                '}';
//    }
}
