package com.example.springtx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Test")
@Data
@AllArgsConstructor
public class Test {
    @Id
    @Column("id")
    Long id;

    @Column("value")
    String value;
}
