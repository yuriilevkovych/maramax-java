package com.maramax.publication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {
    Boolean existsBySlug(String slug);
    Iterable<Publication> findBySlug(String slug);
}
