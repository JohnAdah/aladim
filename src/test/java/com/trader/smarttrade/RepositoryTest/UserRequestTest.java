package com.trader.smarttrade.RepositoryTest;

import com.trader.smarttrade.Entities.UserRequest;
import com.trader.smarttrade.Entities.Users;
import com.trader.smarttrade.Repositories.UserRequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRequestTest {

    @Autowired
    private UserRequestRepository requestRepo;

    @Test
    public void Context(){

    }

    @Test
    public void createRequestTest(){

        Users newUser = new Users();
        newUser.setUserId("USR091122154555116");
        UserRequest request = new UserRequest();
        request.setRequestCategory(MerchantCategory.FASHION);
        request.setRequestMinPrice(2000.00);
        request.setRequestMaxPrice(3900.06);
        request.setImageUrl("check/the/image.url");
        request.setUser_id(newUser);

        requestRepo.save(request);

    }
}
