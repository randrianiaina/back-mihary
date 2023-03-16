package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    @Autowired
    DealRepository dealRepository;
    public List<Deal> dealList()
    {
        return dealRepository.findAll();
    }
    public Deal save(Deal deal){
       return dealRepository.save(deal);
    }
    public void delete(Integer id){
        dealRepository.deleteById(id);
    }
}
