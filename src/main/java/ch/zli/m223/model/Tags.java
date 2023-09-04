package ch.zli.m223.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Tags {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    public Long getTagId() {
        return id;
    }

    public void setTagId(Long id) {
        this.id = id;
    }

    public String getTagTitle() {
        return title;
    }

    public void setTagTitle(String title) {
        this.title = title;
    }

}
