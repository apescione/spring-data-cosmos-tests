package com.example.petmanagement.data;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Patient cosmos document.
 */
@Repository
public interface PetRepository extends CosmosRepository<Pet, String> {

    Page<Pet> findByNameAndFood(String name, String food, Pageable pageable);

    Page<Pet> findByName(String name, Pageable pageable);

}
