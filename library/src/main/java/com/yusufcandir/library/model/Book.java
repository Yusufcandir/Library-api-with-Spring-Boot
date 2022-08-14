package com.yusufcandir.library.model;

import com.yusufcandir.library.enumeration.Genre;
import lombok.*;
import javax.persistence.*;




@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String author;
    private Integer stock;
    private Genre genre;




}
