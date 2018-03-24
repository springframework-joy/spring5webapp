package com.srikanth.spring.spring5webapp.repositories;

import com.srikanth.spring.spring5webapp.modal.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
