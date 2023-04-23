package com.example.todolistbackend.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryEntryRepository extends JpaRepository<DictionaryEntry, Integer> {

    long countByLanguageCode(String code);

    List<DictionaryEntry> findAllByWordContainingOrTranslationContainingOrDescriptionContaining(String word, String transaction, String description);

}
