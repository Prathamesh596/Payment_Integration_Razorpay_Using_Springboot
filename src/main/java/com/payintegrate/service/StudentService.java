package com.payintegrate.service;

import com.payintegrate.dto.StudentOrder;
import com.payintegrate.repo.StudentOrderRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentOrderRepo studentRepo;

    @Value("${razorpay.key.id}")
    private String razorPayKey;

    @Value("${razorpay.secret.key}")
    private String razorPaySecret;

    private RazorpayClient client;

    public StudentOrder createOrder(StudentOrder order) throws Exception {
        // Initialize Razorpay client
        this.client = new RazorpayClient(razorPayKey, razorPaySecret);

        // Prepare order request
        JSONObject orderReq = new JSONObject();
        orderReq.put("amount", order.getAmount() * 100);  // Amount in paise
        orderReq.put("currency", "INR");
        orderReq.put("receipt", order.getEmail());

        // Create Razorpay order
        Order razorpayOrder = client.orders.create(orderReq);
        System.out.println("Razorpay Order: " + razorpayOrder);

        // Set order details and save to DB
        order.setRazorpayOrderId(razorpayOrder.get("id"));
        order.setOrderStatus(razorpayOrder.get("status"));

        StudentOrder savedOrder = studentRepo.save(order);

        return savedOrder;
    }

    public StudentOrder updateOrder(Map<String, String> responsePayload) {
        String razorpayOrderId = responsePayload.get("razorpay_order_id");

        StudentOrder order = studentRepo.findByRazorpayOrderId(razorpayOrderId);
        if (order != null) {
            order.setOrderStatus("Payment Success");
            return studentRepo.save(order);
        }

        throw new RuntimeException("Order not found with Razorpay Order ID: " + razorpayOrderId);
    }
}
