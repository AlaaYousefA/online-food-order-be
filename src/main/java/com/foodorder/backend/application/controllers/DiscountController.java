package com.foodorder.backend.application.controllers;

import com.foodorder.backend.application.dtos.discount.CreateDiscountRequest;
import com.foodorder.backend.application.dtos.discount.CreateDiscountResponse;
import com.foodorder.backend.domain.mappers.DiscountMapper;
import com.foodorder.backend.domain.model.Discount;
import com.foodorder.backend.domain.services.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<CreateDiscountResponse> updateDiscount(@PathVariable("id") Long id, @RequestBody CreateDiscountRequest request) {
        Discount discount = discountMapper.CreateDiscountRequestToModel(request);
        return ResponseEntity.ok(discountMapper.modelToCreateDiscountResponse(discountService.updateDiscount(id, discount)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscount(@PathVariable("id") Long id) {
        return ResponseEntity.ok(discountService.getDiscount(id));
    }

    @GetMapping
    public ResponseEntity<Page<Discount>> getAllDiscounts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "createdAt") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "desc") String sortDirection
    ) {
        return ResponseEntity.ok(discountService.getAllDiscounts(page, size, sortBy, sortDirection));
    }

    @PutMapping("/update-food-items-discounts")
    public ResponseEntity<List<Long>> updateFoodItemsDiscounts(@RequestBody List<Long> ids,@RequestParam(name = "discountId") Long discountId) {
        return ResponseEntity.ok(discountService.updateFoodItemsDiscounts(ids, discountId));
    }
}
