package com.example.demo.mapper;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target ="nameEn", source = "name")
    ProductModel toModel(Product product);


    Product toEntity(ProductModel productModel);
}
