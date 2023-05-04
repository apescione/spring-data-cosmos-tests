package com.example.petmanagement.web;


import com.azure.spring.data.cosmos.core.query.CosmosPageRequest;
import com.example.petmanagement.data.Pet;
import com.example.petmanagement.data.PetReactiveRepository;
import com.example.petmanagement.data.PetRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final static String[] names = new String[]{"Pluto", "Topolino", "Pippo", "Frank", "Pocoyo", "Bing", "Sula", "Lula", "Moon", "Ronfotto"};
    private final static String[] types = new String[]{"Cat", "Dog", "Lion", "Bird", "Mouse", "Fox", "Rabbit", "Duke", "Ant", "Bee"};
    private final static String[] food = new String[]{"vegetarian", "omnivore"};
    @Autowired
    private PetRepository petRepository;

//    @Autowired
//    private PetReactiveRepository petReactiveRepository;


    /**
     * Api to populate collection
     * @return
     */
    @PostMapping
    public ResponseEntity<String> createPets() {
        Random random = new Random();
        IntStream.range(1, 500000)
                .forEach(i -> {
                    Pet newPet = new Pet();
                    newPet.setCode(random.nextInt() + "");
                    newPet.setAge(random.nextInt(40));
                    newPet.setName(names[random.nextInt(10)]);
                    newPet.setType(types[random.nextInt(10)]);
                    newPet.setFood(food[random.nextInt(2)]);
                    newPet.setNote("nonote");
                    newPet.setFamilySurname("Pescione");
                    petRepository.save(newPet);
                });
        return ResponseEntity.ok("OK");
    }


    @GetMapping
    public ResponseEntity<List<Pet>> searchPet(Integer page, Integer size) {
        //Pageable pageable = CosmosPageRequest.of(Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(Integer.MAX_VALUE));
        //This is just to reproduce the Thread Stuck in local environment, it is not a best practice, but just to simulate a long response
        return ResponseEntity.ok(IteratorUtils.toList(petRepository.findAll().iterator()));
        //Using this API, it's possible to choose a timeout and to avoid the thread stuck
        //return ResponseEntity.ok(petReactiveRepository.findAll().collectList().block(Duration.ofMinutes(1)));
    }


}
