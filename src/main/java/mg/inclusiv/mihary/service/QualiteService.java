package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Qualite;
import mg.inclusiv.mihary.repository.QualiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualiteService {
    @Autowired
    QualiteRepository qualiteRepository;

    public List<Qualite> listAll(){
        return qualiteRepository.findAll();
    }

    public void save(Qualite qualite){
        qualiteRepository.save(qualite);
    }
}
