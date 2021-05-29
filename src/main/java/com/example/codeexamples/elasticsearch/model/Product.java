package com.example.codeexamples.elasticsearch.model;

import com.example.codeexamples.elasticsearch.dto.Information;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Accessors(chain = true)
@Document(indexName = "product")
public class Product {

    @Id
    @ReadOnlyProperty
    private String id;

    @NotNull
    @Field(type = FieldType.Keyword)
    private String name;

    @NotNull
    @Field(type = FieldType.Object)
    private Information information;

    @NotNull
    @Field(type = FieldType.Boolean)
    private boolean isAvailable;

}
