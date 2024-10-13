package com.foodorder.backend.application.controllers;

import com.foodorder.backend.application.dtos.discount.CreateDiscountRequest;
import com.foodorder.backend.application.dtos.discount.CreateDiscountResponse;
import com.foodorder.backend.domain.mappers.DiscountMapper;
import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.domain.services.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discount")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;
    private final DiscountMapper discountMapper;

    @PostMapping
    public ResponseEntity<CreateDiscountResponse> createDiscount(@RequestBody CreateDiscountRequest request) {
        Discount discount = discountMapper.CreateDiscountRequestToModel(request);

        return ResponseEntity.ok(discountMapper.modelToCreateDiscountResponse(discountService.createDiscount(discount)));
    }
}
