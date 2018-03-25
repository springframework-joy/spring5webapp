package com.srikanth.spring.spring5webapp.repositories;

import com.srikanth.spring.spring5webapp.modal.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
