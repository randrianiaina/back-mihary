package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DealService {
    @Autowired
    DealRepository dealRepository;
    public List<Deal> dealList()
    {
        return dealRepository.findAll();
    }
    public void save(Deal deal){
        dealRepository.save(deal);
    }
    public void delete(Integer id){
        dealRepository.deleteById(id);
    }
}
