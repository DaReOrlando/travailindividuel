package be.labil.rest.services;

import be.labil.rest.models.Etudiant;
import be.labil.rest.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant insert(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> list() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant update(Long id, Etudiant etudiant) {
        return etudiantRepository.findById(id)
                .map(e -> {
                    e.setNom(etudiant.getNom());
                    e.setPrenom(etudiant.getPrenom());
                    e.setMatricule(etudiant.getMatricule());
                    e.setMasterType(etudiant.getMasterType());
                    return etudiantRepository.save(etudiant);
                }).orElseThrow(()-> new RuntimeException("Etudiant inconnu"));
    }

    @Override
    public Boolean delete(Long id) {
        etudiantRepository.deleteById(id);
        return true;
    }
}
