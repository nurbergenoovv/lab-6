package com.nurbergenovv.lab5.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity()
@Table(name = "application_requests")
public final class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String commentary;
    private String phone;
    private boolean handled = false;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "application_requests_operators",
            joinColumns = @JoinColumn(name = "application_request_id"),
            inverseJoinColumns = @JoinColumn(name = "operators_id")
    )
    private List<Operator> operators;

}
