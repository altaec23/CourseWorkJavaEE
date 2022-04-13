package ru.alon.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString (exclude = "owner")
public class LightSaber {
    private long id;
    private String model;
    private Jedi owner;
}
