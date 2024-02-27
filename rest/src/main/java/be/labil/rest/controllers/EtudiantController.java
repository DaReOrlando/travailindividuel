package be.labil.rest.controllers;

import be.labil.rest.models.Etudiant;
import be.labil.rest.services.EtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Etudiant", description = "L'api des étudiants")
@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {
    public final EtudiantService etudiantService;


    @PostMapping(value="/create", produces = "application/json")
    Etudiant create(@RequestBody Etudiant etudiant){
        return etudiantService.insert(etudiant);
    }

    @Operation(
            summary = "Récupération de la liste des étudiants",
            description = "Retourne la liste de tous les étudiants avec leurs matricules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie")
    })
    @GetMapping(value="/list", produces="application/json")
    List<Etudiant> read(){
        return etudiantService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    Etudiant update(@PathVariable Long id, @RequestBody Etudiant etudiant){
        return etudiantService.update(id, etudiant);
    }

    @DeleteMapping("/delete/{id}")
    Boolean delete(@PathVariable Long id){
        return etudiantService.delete(id);
    }
}
