package com.jvarela.quotesspring;

import org.springframework.data.repository.CrudRepository;

public interface QuotesRepository extends CrudRepository<Quotes, Integer>{
    
}