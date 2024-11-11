package com.example.codoceanbmongo.payment.service;

import com.example.codoceanbmongo.auth.entity.User;
import com.example.codoceanbmongo.auth.service.UserService;
import com.example.codoceanbmongo.payment.dto.PaymentDTO;
import com.example.codoceanbmongo.payment.entity.Payment;
import com.example.codoceanbmongo.payment.exception.PaymentNotFoundException;
import com.example.codoceanbmongo.payment.mapper.PaymentMapper;
import com.example.codoceanbmongo.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<PaymentDTO> getPayments(String authHeader) {
        User user = userService.getUserDetailsFromToken(authHeader);
        return paymentMapper.toDTOs(user.getPayments());
    }

    @Override
    public PaymentDTO getPayment(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found!"));
        return paymentMapper.toDTO(payment);
    }
}
