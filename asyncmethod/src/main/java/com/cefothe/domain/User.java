package com.cefothe.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * Created by cefothe on 22.05.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String blog;
}
