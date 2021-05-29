package com.example.codeexamples.elasticsearch.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Accessors(chain = true)
public class Information {

    @NotNull
    @Field(type = FieldType.Text)
    private String description;

    @NotNull
    @Field(type = FieldType.Text)
    private String materials;

    @NotNull
    @Field(type = FieldType.Text)
    private String packaging;

    @Field(type = FieldType.Text)
    private String instruction;

}
