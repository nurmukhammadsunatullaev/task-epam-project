package com.epam.esm.rest;

import com.epam.esm.model.GiftCertificateModel;
import com.epam.esm.service.custom.GiftCertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gift")
@RequiredArgsConstructor
public class GiftCertificateController {

    private final GiftCertificateService giftCertificateService;

    @GetMapping
    public ResponseEntity<List<GiftCertificateModel>> get(){
        return ResponseEntity.ok(giftCertificateService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<GiftCertificateModel> get(@PathVariable Long id){
        Optional<GiftCertificateModel> model = giftCertificateService.getById(id);
        return model.map(ResponseEntity::ok).orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping
    public ResponseEntity<GiftCertificateModel> post(@RequestBody GiftCertificateModel gift){
        return ResponseEntity.ok(giftCertificateService.save(gift));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiftCertificateModel> put(@PathVariable Long id, @RequestBody GiftCertificateModel gift){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(giftCertificateService.delete(id));
    }
}
