package com.steve.boot.launch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SuperHero {
    /**
     * {
     *   "squadName": "Super hero squad",
     *   "homeTown": "Metro City",
     *   "formed": 2016,
     *   "secretBase": "Super tower",
     *   "active": true,
     *   "members": [
     *     {
     *       "name": "Molecule Man",
     *       "age": 29,
     *       "secretIdentity": "Dan Jukes",
     *       "powers": [
     *         "Radiation resistance",
     *         "Turning tiny",
     *         "Radiation blast"
     *       ]
     *     },
     *     {
     *       "name": "Madame Uppercut",
     *       "age": 39,
     *       "secretIdentity": "Jane Wilson",
     *       "powers": [
     *         "Million tonne punch",
     *         "Damage resistance",
     *         "Superhuman reflexes"
     *       ]
     *     },
     *     {
     *       "name": "Eternal Flame",
     *       "age": 1000000,
     *       "secretIdentity": "Unknown",
     *       "powers": [
     *         "Immortality",
     *         "Heat Immunity",
     *         "Inferno",
     *         "Teleportation",
     *         "Interdimensional travel"
     *       ]
     *     }
     *   ]
     * }
     */

    @JsonProperty("squadName")
    private String squadName;
    @JsonProperty("homeTown")
    private String homeTown;
    @JsonProperty("formed")
    private Integer formed;
    @JsonProperty("secretBase")
    private String secretBase;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("members")
    private List<MembersDTO> members;

    @NoArgsConstructor
    @Data
    public static class MembersDTO {
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private Integer age;
        @JsonProperty("secretIdentity")
        private String secretIdentity;
        @JsonProperty("powers")
        private List<String> powers;
    }
}
