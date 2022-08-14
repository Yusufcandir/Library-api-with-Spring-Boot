package com.yusufcandir.library.model;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;


import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String readerName;
    @ElementCollection(targetClass = Integer.class)
    @Column
    private List<Integer> bookIdList;


    private boolean isDeliveryDateExpired;

    private Double fine;


    @ManyToAny(
            metaDef = "ListNameBooks",
            metaColumn = @Column(name = "book_list"),
            fetch = FetchType.EAGER)
    private List<Book> book;





}
