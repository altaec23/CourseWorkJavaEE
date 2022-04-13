package ru.alon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jedi {
    private long id;
    private String firstName;
    private String lastName;
    List<LightSaber> lightSabers;
}
