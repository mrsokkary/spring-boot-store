package org.codewithme.store.mappers;

import org.codewithme.store.dtos.ProductDto;
import org.codewithme.store.entities.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    @InheritConfiguration
    ProductDto toDto(Product product);
}
