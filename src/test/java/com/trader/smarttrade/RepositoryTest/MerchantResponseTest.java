package com.trader.smarttrade.RepositoryTest;


import com.trader.smarttrade.Entities.MerchantResponse;
import com.trader.smarttrade.Entities.Merchants;
import com.trader.smarttrade.Repositories.MerchantResponseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MerchantResponseTest {

    @Autowired
    private MerchantResponseRepository responseRepo;

    @Test
    public void Context(){

    }

    @Test
    public void createMerchantResponse(){
        Merchants merchant = new Merchants();
        MerchantResponse response = new MerchantResponse();
        response.setResponseDescription("Maximum Litre of 20,000 capacity with support stands");
        response.setResponsePrice(4000.00);
        response.setImageUrl("This is the image link for what is needed");
    }
}
