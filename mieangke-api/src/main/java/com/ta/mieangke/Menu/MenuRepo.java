package com.ta.mieangke.Menu;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MenuRepo extends CrudRepository<Menu, Integer>{
    @Query("SELECT a FROM Menu a WHERE a.name LIKE %:name% ")
  public Iterable<Menu> findMenuByName(@Param("name") String name);
}
