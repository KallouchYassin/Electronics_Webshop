package com.ehb.Elecrtonics.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="cat_nam")

    private @NotBlank  String cat_name;
    @Column(name="description")
    private @NotBlank String description ;
    @Column(name="url")
    private @NotBlank  String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
