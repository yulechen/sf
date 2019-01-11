package com.example.sf;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ODataApiServiceImpl implements ODataApiService {

  // use config

  String api="";
  String companyCode ="";
  String user="";
  String pwd="";

  @Autowired
  RestTemplate restTemplate;

  /**
   *  no  exception handle
   * @param
   * @return
   */
  @Override
  public String operation(String subPath) {
    String callUrl=String.format("%s%s",api,subPath);
    HttpEntity<String> request = getRequest(companyCode, user, pwd, null);
    ResponseEntity<String> exchange = restTemplate
        .exchange(callUrl, HttpMethod.GET, request, String.class);
    return exchange.getBody();
  }


  private HttpEntity<String> getRequest(String companyCode,String user,String pwd,String  body){
    // cache this
    String authorization = Base64.getEncoder()
        .encodeToString(String.format("%s@%s:%s", user, companyCode, pwd).getBytes());
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add("Authorization","Basic "+authorization);
    return new HttpEntity(body, requestHeaders);
  }

  public static void main(String[] args) {
    ODataApiServiceImpl oDataApiService = new ODataApiServiceImpl();
    oDataApiService.restTemplate=new RestTemplate();
    System.out.println(oDataApiService.operation("User('1')"));
  }

}
