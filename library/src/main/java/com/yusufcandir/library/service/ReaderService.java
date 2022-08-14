package com.yusufcandir.library.service;


import com.yusufcandir.library.model.Reader;
import com.yusufcandir.library.repository.ReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;




    public Reader requestOrder(List<Integer> bookIdList, String readerName) {
        List<Optional<Reader>> readerRequestList= bookIdList.stream()
                .map(readerRepository::findById).toList();


        Double fee = readerRequestList.stream().map(k->k.map(Reader::getFine).orElse(0.0))
                .reduce(0.0, Double::sum);





        Reader reader1= Reader.builder().readerName(readerName).bookIdList(bookIdList).fine(fee).isDeliveryDateExpired(false).
             build();
        expiredDate(reader1);

        return readerRepository.save(reader1);
    }



    public void expiredDate(Reader reader){


       if (!reader.isDeliveryDateExpired()){
           reader.setFine(0.0);

       }
       else reader.setFine(50.0);
       readerRepository.save(reader);
    }

    public List<Reader> getAllReaders(){
        return readerRepository.findAll();

    }
}