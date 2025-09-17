package com.payintegrate.controller;

import com.payintegrate.dto.StudentOrder;
import com.payintegrate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String init() {
        return "index";
    }

    @PostMapping(value = "/create-order", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<StudentOrder> createOrder(@RequestBody StudentOrder studentOrder) throws Exception {
        StudentOrder createdOrder = service.createOrder(studentOrder);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    // Handle payment callback and return success page
    @PostMapping("/handle-payment-callback")
    public String handlePaymentCallback(@RequestParam Map<String, String> respPayload) {
        System.out.println("Payment Callback Response: " + respPayload);

        service.updateOrder(respPayload);

        return "success";
    }
}
