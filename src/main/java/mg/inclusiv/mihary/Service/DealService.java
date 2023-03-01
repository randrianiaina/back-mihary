package mg.inclusiv.mihary.Service;

import mg.inclusiv.mihary.Entity.Deal;
import mg.inclusiv.mihary.Repository.DealRepository;
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
