package nl.craftsmen.blogdemo.api.model;

import lombok.Builder;

@Builder
public record OrderModel(String product, int quantity) {}
