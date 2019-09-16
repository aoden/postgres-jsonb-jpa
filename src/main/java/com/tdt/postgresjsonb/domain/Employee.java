package com.tdt.postgresjsonb.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdt.postgresjsonb.config.ObjectMapperHolder;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@TypeDef(
        name = "jsonb-node",
        typeClass = JsonNodeBinaryType.class
)
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id", callSuper = false)
public class Employee extends BaseDomain {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Type( type = "jsonb-node" )
    JsonNode info;

    public String toString() {
        ObjectMapper objectMapper = ObjectMapperHolder.getObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
