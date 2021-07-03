package nl.craftsmen.blogdemo.core.domain;

import lombok.Builder;

@Builder
public record Order(String product, int quantity) {
}

