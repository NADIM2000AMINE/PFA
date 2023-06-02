package com.pfa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Clause")
public class Clause {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "requirements")
    private String requirements;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id", nullable = false)
    private Standard standard;

    @Column(name = "desc_exigence")
    private String exigenceDescription;

    @Column(name = "etat", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClauseStatus status;

    // Getters and setters

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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public String getExigenceDescription() {
        return exigenceDescription;
    }

    public void setExigenceDescription(String exigenceDescription) {
        this.exigenceDescription = exigenceDescription;
    }

    public ClauseStatus getStatus() {
        return status;
    }

    public void setStatus(ClauseStatus status) {
        this.status = status;
    }
}

