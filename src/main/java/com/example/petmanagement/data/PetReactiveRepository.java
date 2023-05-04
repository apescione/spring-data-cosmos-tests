package com.example.petmanagement.data;


import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the Patient cosmos document.
 */
@Repository
public interface PetReactiveRepository extends ReactiveCosmosRepository<Pet, String> {


}
