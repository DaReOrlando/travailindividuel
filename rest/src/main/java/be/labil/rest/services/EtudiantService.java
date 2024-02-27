package be.labil.rest.services;

import be.labil.rest.models.Etudiant;

import java.util.List;

public interface EtudiantService {

    Etudiant insert(Etudiant etudiant);

    List<Etudiant> list();

    Etudiant update(Long id, Etudiant etudiant);

    Boolean delete(Long id);
}
