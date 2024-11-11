package com.example.codoceanbmongo.payment.mapper;

import com.example.codoceanbmongo.payment.dto.PaymentDTO;
import com.example.codoceanbmongo.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDTO toDTO(Payment payment);

    List<PaymentDTO> toDTOs(List<Payment> payments);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "paymentMethod", target = "paymentMethod")
    @Mapping(source = "paymentStatus", target = "paymentStatus")
    @Mapping(source = "paymentDate", target = "paymentDate")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "currency", target = "currency")
    Payment toEntity(PaymentDTO paymentDTO);

    List<Payment> toEntities(List<PaymentDTO> paymentDTOS);
}
