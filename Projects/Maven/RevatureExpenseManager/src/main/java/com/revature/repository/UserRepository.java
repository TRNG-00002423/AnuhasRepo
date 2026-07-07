package com.revature.repository;

public interface UserRepository extends JpaRepository <User, Integer>{
    @Query(value = "SELECT * FROM User WHERE email = : email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
    
}
