package com.srikanth.spring.spring5webapp.repositories;

import com.srikanth.spring.spring5webapp.modal.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
