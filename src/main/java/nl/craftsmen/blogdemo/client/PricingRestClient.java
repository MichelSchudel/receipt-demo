package nl.craftsmen.blogdemo.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "pricing", url="${pricing.service.url}")
public interface PricingRestClient {

    @RequestMapping(method = RequestMethod.POST, value = "/{productName}", produces = "application/json")
    PriceModel getPrice(@PathVariable("productName") String productName);
}
