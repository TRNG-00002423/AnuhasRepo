package com.revature.repository;

import com.revature.model.Approval;

public interface ApprovalRepository extends JpaRepository <Approval, Integer>{
    @Query(value = "SELECT * FROM Approvals WHERE reviewer = : reviewer", nativeQuery = true)
    Approval findByReviewer(@Param("reviewer") String reviewer);
    
}
