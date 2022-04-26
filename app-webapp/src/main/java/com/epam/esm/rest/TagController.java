package com.epam.esm.rest;

import com.epam.esm.model.TagModel;
import com.epam.esm.service.custom.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<TagModel>> get(){
        return ResponseEntity.ok(tagService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagModel> get(@PathVariable Long id){
        Optional<TagModel> tag = tagService.getById(id);
        return tag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public  ResponseEntity<TagModel> post(@RequestBody TagModel tag){
        return ResponseEntity.ok(tagService.save(tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(tagService.delete(id));
    }


}
