package ru.alon.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "owner")
@Table
@Entity
public class LightSaber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String model;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Jedi owner;
}
