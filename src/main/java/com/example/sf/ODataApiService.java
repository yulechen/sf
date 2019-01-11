package com.example.sf;

public interface ODataApiService {


  /**
   * exmaple
   * curl --basic -u apiuser@SFPART033161:123qwe! https://apisalesdemo2.successfactors.eu/odata/v2/User\('1'\)
   *
   * @return
   */
  String operation(String subPath);


}
