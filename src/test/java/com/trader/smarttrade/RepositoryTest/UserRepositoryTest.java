package com.trader.smarttrade.RepositoryTest;


import com.trader.smarttrade.Entities.Address;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Enums.IdentityType;
import com.trader.smarttrade.Enums.UserRole;
import com.trader.smarttrade.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void Context(){

    }

    @Test
    public void CreateUserTest(){
        Users user = new Users();
        Merchants merchant = new Merchants();
        Address address = new Address();

        merchant.setBvn(8253545L);
        merchant.setCacRegistrationNumber("7683");
        merchant.setBusinessName("Anita Bakery");
        merchant.setMerchantCategory(MerchantCategory.AGRICULTURE);

        address.setAddressLine1("242, Kofo Abayomi Street,");
        address.setAddressLine2("Victoria Island Lagos");
        address.setCity("Lagos");
        address.setCountry("Nigeria");
        address.setLocalGovArea("Alimosho");
        address.setPostalCode(420271);
        address.setStateOfCity("Lagos");


        user.setUserName("Jodiny");
        user.setFirstName("John");
        user.setLastName("Anyebe");
        user.setEmail("kon4aet@gmail.com");
        user.setIdNumber(10000004L);
        user.setIdType(IdentityType.VOTERS_CARD);
        user.setRole(UserRole.MERCHANT);
        user.setHomeAddress(address);
        user.setPassword("japa");
        user.setMerchant(merchant);
        user.setPhoneNumber("0704567387");

        userRepository.save(user);
    }

    @Test
    public void updateUser(){
        Users user = new Users();
        Merchants merchant = new Merchants();
        Address address = new Address();

        merchant.setBvn(8253545L);
        merchant.setCacRegistrationNumber("7683");
        merchant.setBusinessName("Anita Bakery");
        merchant.setMerchantCategory(MerchantCategory.AGRICULTURE);

        address.setAddressLine1("242, Kofo Abayomi Street,");
        address.setAddressLine2("Victoria Island Lagos");
        address.setCity("Lagos");
        address.setCountry("Nigeria");
        address.setLocalGovArea("Alimosho");
        address.setPostalCode(420271);
        address.setStateOfCity("Lagos");


        user.setUserName("Jodiny");
        user.setFirstName("John");
        user.setLastName("Anyebe");
        user.setEmail("kon4aet@gmail.com");
        user.setIdNumber(10000004L);
        user.setIdType(IdentityType.VOTERS_CARD);
        user.setRole(UserRole.MERCHANT);
        user.setHomeAddress(address);
        user.setPassword("japa");
        user.setMerchant(merchant);
        user.setPhoneNumber("0704567387");

        Optional<Users> userUpdate = userRepository.findById("USR091122154555116");
        if(userUpdate.isPresent()){

        }

    }
}
