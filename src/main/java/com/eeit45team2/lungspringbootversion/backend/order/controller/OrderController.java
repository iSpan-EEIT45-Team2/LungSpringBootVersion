package com.eeit45team2.lungspringbootversion.backend.order.controller;

import com.eeit45team2.lungspringbootversion.backend.order.constant.OrderStatus;
import com.eeit45team2.lungspringbootversion.backend.order.model.Order;
import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import com.eeit45team2.lungspringbootversion.backend.order.pay.EcpayPayment;
import com.eeit45team2.lungspringbootversion.backend.order.pay.PaypalPayment;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/Order/ECPAY/Result")
    public String result(@RequestParam("RtnCode") String rtnCode,
                         @RequestParam("MerchantTradeNo") String merchantTradeNo,
                         RedirectAttributes model) {
        System.out.println("RtnCode: " + rtnCode);
        System.out.println("MerchantTradeNo: " + merchantTradeNo);

        Order order = orderService.findByOrderNo(merchantTradeNo).orElse(null);
        if(rtnCode.equals("1")) {
            if(order!=null) {
                orderService.pay(order.getOrderId());
            }
        }
        model.addFlashAttribute("orderNo", order.getOrderNo());
        return "redirect:/Front/products";
    }

    @GetMapping ("/Order/PAYPAL/Result")
    public String resultPaypal(@RequestParam String token,
                               RedirectAttributes  model) {
        System.out.println("Token: " + token);
        String orderNo = PaypalPayment.captureOrder(token);
        Order order = orderService.findByOrderNo(orderNo).orElse(null);
        if(order!=null) {
            Order pay = orderService.pay(order.getOrderId());
        }
        model.addFlashAttribute("orderNo", order.getOrderNo());
        return "redirect:/Front/products";
    }



    @GetMapping(value = "/Order/{orderNo}/Pay",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> pay(@PathVariable String orderNo, HttpServletRequest request){
        Order order = orderService.findByOrderNo(orderNo).orElse(null);
        String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
        if(order!=null && order.getOrderStatus() == OrderStatus.WAIT_PAYMENT){
            switch (order.getPayType()){
                case ECPAY:
                    String ecpayUrl =  baseURL + "/Order/ECPAY/Result";
                    System.out.println("ecpayUrl:" + ecpayUrl);
                    String string = EcpayPayment.genAioCheckOutALL(order, ecpayUrl);
                    return new ResponseEntity<>(string, HttpStatus.OK);
                case PAYPAL:
                    String paypalUrl =  baseURL + "/Order/PAYPAL/Result";
                    System.out.println("paypalUrl:" + paypalUrl);
                    return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(PaypalPayment.createPayUrl(order,paypalUrl))).build();
            }
        }
        return null;
    }

}
