package com.example.petmanagement.data;

import com.azure.cosmos.models.IndexingMode;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.CosmosIndexingPolicy;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Container(containerName = "pets", autoCreateContainer = false)
@CosmosIndexingPolicy(automatic = true, mode = IndexingMode.CONSISTENT)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Pet implements Serializable {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    @JsonPropertyDescription("id")
    private String id;
    private String name;
    @PartitionKey
    private String type;
    private String familySurname;
    private String code;
    private Integer age;
    private String note;
    private String food;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFamilySurname() {
        return familySurname;
    }

    public void setFamilySurname(String familySurname) {
        this.familySurname = familySurname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
