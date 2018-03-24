package com.srikanth.spring.spring5webapp.bootstrap;

import com.srikanth.spring.spring5webapp.modal.Author;
import com.srikanth.spring.spring5webapp.modal.Book;
import com.srikanth.spring.spring5webapp.repositories.AuthorRepository;
import com.srikanth.spring.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){

        Author eric =  new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(book);


        authorRepository.save(eric);
        bookRepository.save(book);

        Author david =  new Author("David", "Williams");
        Book davidBook = new Book("No to EJB ", "23456", "Manning");
        david.getBooks().add(davidBook);

        authorRepository.save(david);
        bookRepository.save(davidBook);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
