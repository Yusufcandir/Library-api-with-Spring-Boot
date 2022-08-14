package com.yusufcandir.library.dto;




import com.yusufcandir.library.model.Reader;
import lombok.Data;

import javax.persistence.ManyToOne;

import java.util.List;

@Data
public class BookRequest {
    private List<Integer> bookIdList;

    private String readerName;
    @ManyToOne
    private Reader reader;


}
