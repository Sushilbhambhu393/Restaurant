package com.Restaurant.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.razorpay.*;
import org.json.JSONObject;

import java.security.Signature;
import java.util.Collection;
import java.util.Map;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api/payment")
public class PaymentController {

    private static final String KEY_ID = "rzp_test_RJzL1vYgKXXRyC"; // Replace with your Key ID
    private static final String KEY_SECRET = "3DjQU4X9t6RgV6xvvAybB5wr"; // Replace with your Key Secret

    @PostMapping("/create-order")
    public String createOrder(@RequestParam("amount") int amount) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(KEY_ID, KEY_SECRET);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount); // amount should already be in paise from frontend
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "614");
        log.info("Creating order with amount: " + amount);
        Order order = razorpay.orders.create(orderRequest);
//        JSONObject response = new JSONObject();
//        response.put("orderId", (Collection<?>) order.get("id"));
//        response.put("amount", order.get("amount"));
        return order.toString();
    }


    @PostMapping("/payment-callback")
    public RedirectView paymentCallback(
            @RequestParam("razorpay_order_id") String razorpayOrderId,
            @RequestParam("razorpay_payment_id") String razorpayPaymentId,
            @RequestParam("razorpay_signature") String razorpaySignature) throws RazorpayException
             {
        try {
            JSONObject options = new JSONObject();
            options.put("razorpay_order_id", razorpayOrderId);
            options.put("razorpay_payment_id", razorpayPaymentId);
            options.put("razorpay_signature", razorpaySignature);

            String signature = razorpayOrderId + "|" + razorpayPaymentId;
            boolean isValid = Utils.verifySignature(signature, razorpaySignature, KEY_SECRET);

            if (isValid) {
                return new RedirectView("/payment-success.html?orderId=" + "razorpayOrderId");
            } else {
                return new RedirectView("/payment-failure.html");
            }
        } catch (RazorpayException e) {
            System.err.println("Razorpay Exception during callback: " + e.getMessage());
            return new RedirectView("/payment-failure.html");
        } catch (Exception e) {
            System.err.println("General Exception during callback: " + e.getMessage());
            return new RedirectView("/payment-failure.html");
        }
    }


    @PostMapping("/get-key")
    public String getKey() {
        return KEY_ID;
    }
}
