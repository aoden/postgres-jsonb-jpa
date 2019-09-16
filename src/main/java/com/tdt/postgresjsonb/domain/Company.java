package com.tdt.postgresjsonb.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Company extends BaseDomain {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String type;

    String location;

    @Column(columnDefinition = "jsonb-node")
    @Type(type = "jsonb")
    Set<Employee> employees = new HashSet<>();
}
