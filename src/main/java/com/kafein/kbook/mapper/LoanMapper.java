package com.kafein.kbook.mapper;

import com.kafein.kbook.dto.LoanDTO;
import com.kafein.kbook.model.Loan;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, UserMapper.class})
public interface LoanMapper {

    @Named("toLoan")
    Loan toLoan(LoanDTO loanDTO);

    @Named("toLoanDTO")
    @Mapping(target = "books", ignore = true)
    LoanDTO toLoanDTO(Loan loan);

    @IterableMapping(qualifiedByName = "toLoan")
    List<Loan> toLoanList(List<LoanDTO> loanDTOList);

    @IterableMapping(qualifiedByName = "toLoanDTO")
    List<LoanDTO> toLoanDTOList(List<Loan> loanList);

}
