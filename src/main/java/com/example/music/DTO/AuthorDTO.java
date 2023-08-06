package com.example.music.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Integer id;
    private String nameAuthor;
    private String nationality;
    private LocalDate dateOfBirth;
    private String gender;
    private String image;
    private String describeAuthor;
}
