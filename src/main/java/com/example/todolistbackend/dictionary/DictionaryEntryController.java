package com.example.todolistbackend.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary/entry")
public class DictionaryEntryController {

    @Autowired
    private DictionaryEntryRepository dictionaryEntryRepository;

    @GetMapping
    public List<DictionaryEntry> list(){
        return dictionaryEntryRepository.findAll();
    }

    @GetMapping("/property/count")
    public long count (@RequestParam(required = false) String code){
        if (code == null){
            return dictionaryEntryRepository.count();
        } else {
            return dictionaryEntryRepository.countByLanguageCode(code);
        }
    }

    @GetMapping("/operation/search")
    public List<DictionaryEntry> search (@RequestParam String text){
        return dictionaryEntryRepository.findAllByWordContainingOrTranslationContainingOrDescriptionContaining(text, text, text);
    }


    @GetMapping("/{id}")
    public DictionaryEntry get(@PathVariable Integer id){
        return dictionaryEntryRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        dictionaryEntryRepository.deleteById(id);
    }

    @PostMapping
    public DictionaryEntry create (@RequestBody DictionaryEntry dictionaryEntry){
        dictionaryEntry.setId(null);
        return dictionaryEntryRepository.save(dictionaryEntry);
    }

    @PutMapping
    public DictionaryEntry update (@RequestBody DictionaryEntry dictionaryEntry){
        DictionaryEntry existing = get(dictionaryEntry.getId());
        existing.setDescription(dictionaryEntry.getDescription());
        existing.setTranslation(dictionaryEntry.getTranslation());
        existing.setWord(dictionaryEntry.getWord());
        return dictionaryEntryRepository.save(existing);
    }


}
