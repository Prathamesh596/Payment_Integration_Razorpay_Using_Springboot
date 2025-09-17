package com.payintegrate.repo;

import com.payintegrate.dto.StudentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrderRepo extends JpaRepository<StudentOrder, Integer> {

    StudentOrder findByRazorpayOrderId(String razorpayOrderId);
}
