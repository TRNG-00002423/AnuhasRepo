package com.revature.repository;

import com.revature.model.Expense;

public interface ExpenseRepository extends JpaRepository <Expense, Integer>{
    @Query(value = "SELECT * FROM Expense WHERE userId = : userId", nativeQuery = true)
    Expense findByUserId(@Param("userId") String userId);
    
}
