package com.ironahck.temporarymails.proxy;

import com.ironahck.temporarymails.dto.Account;
import com.ironahck.temporarymails.dto.MyToken;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MailTm", url = "https://api.mail.tm/")
public interface MailTmProxy {


        @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
        Account getAccountById(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @PathVariable String id);


        @RequestMapping(method = RequestMethod.POST, value = "/token")
        MyToken getToken(@RequestParam String address, @RequestParam String password);



     /*   @GetMapping("/accounts/{id}")
        @Headers("Authorization : Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NzExMzU5MzIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJ1c2VybmFtZSI6Iml2YW5AbmlnaHRvcmIuY29tIiwiaWQiOiI2MzliODI5NmY0NTEyNTkyZjMxMDQ1ZTIiLCJtZXJjdXJlIjp7InN1YnNjcmliZSI6WyIvYWNjb3VudHMvNjM5YjgyOTZmNDUxMjU5MmYzMTA0NWUyIl19fQ.m3MxgONlf1Qir0JpZbZZQkIw1LkkXSrJSzb5guAQgNt0M-jcr-Q6x6XZZKAk1SB7IISQjlb-XYRWaocDauvSpw")
        Account getAccountById(@PathVariable String id);*/
}

/*@FeignClient(name = "weather", url = "https://goweather.herokuapp.com/weather/")
public interface WeatherProxy {
    @GetMapping("{city}")
    Weather getWeatherByCity(@PathVariable String city);
}*/
