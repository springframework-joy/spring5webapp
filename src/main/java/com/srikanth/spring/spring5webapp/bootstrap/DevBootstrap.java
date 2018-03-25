package com.srikanth.spring.spring5webapp.bootstrap;

import com.srikanth.spring.spring5webapp.modal.Author;
import com.srikanth.spring.spring5webapp.modal.Book;
import com.srikanth.spring.spring5webapp.modal.Publisher;
import com.srikanth.spring.spring5webapp.repositories.AuthorRepository;
import com.srikanth.spring.spring5webapp.repositories.BookRepository;
import com.srikanth.spring.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher manningPublisher = new Publisher("Manning", "XYZ Street" , "New York City", "NY", "23232");
        Publisher oraclePublisher = new Publisher("Oracle", "ZZZZ Street" , "Greensboro", "NC", "23232");
        publisherRepository.save(manningPublisher);
        publisherRepository.save(oraclePublisher);

        publisherRepository.save(manningPublisher);


        Author eric =  new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "1234", manningPublisher);
        eric.getBooks().add(book);


        authorRepository.save(eric);
        bookRepository.save(book);

        Author david =  new Author("David", "Williams");
        Book davidBook = new Book("No to EJB ", "23456", oraclePublisher);
        david.getBooks().add(davidBook);

        authorRepository.save(david);
        bookRepository.save(davidBook);



    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
