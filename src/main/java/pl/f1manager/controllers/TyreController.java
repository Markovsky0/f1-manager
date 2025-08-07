package pl.f1manager.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.f1manager.model.db.Tyre;
import pl.f1manager.repositories.TyreRepository;

import java.util.List;

@RestController
@RequestMapping("/tyres")
@Slf4j
public class TyreController {
    private final TyreRepository tyreRepository;

    public TyreController(TyreRepository tyreRepository) {
        this.tyreRepository = tyreRepository;
    }

    @GetMapping("/")
    public List<Tyre> getTyres() {
        log.info("GET /tyres endpoint invoked");
        return tyreRepository.findAll();
    }
}
