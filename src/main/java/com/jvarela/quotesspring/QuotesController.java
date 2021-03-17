package com.jvarela.quotesspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
@RequestMapping("/quotes")
public class QuotesController {
    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Quotes> getAllQuotes(){
        return quotesRepository.findAll();
    }

    @GetMapping("/random")
    public @ResponseBody Optional<Quotes> getRandomQuote(){
        Long quotesSize=quotesRepository.count();
        int randomIdQuote=(int)(Math.random()*(quotesSize-1)+1);
        return quotesRepository.findById(randomIdQuote);
    }

    @PostMapping("/add")
    public @ResponseBody String addNewQuote(@RequestParam String quote, @RequestParam String author){
        Quotes newQuote=new Quotes();
        newQuote.setQuote(quote);
        newQuote.setAuthor(author);
        quotesRepository.save(newQuote);
        return "New Quote Saved";
    }
}
