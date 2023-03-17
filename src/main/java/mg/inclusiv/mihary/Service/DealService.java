package mg.inclusiv.mihary.service;

import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    public Optional<Deal> getDealById(Integer dealId) {
        return dealRepository.findById(dealId);
    }

    public Deal saveDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    public Deal updateDeal(Integer dealId, Deal dealDetails) throws ResourceNotFoundException {
        Deal deal = dealRepository.findById(dealId)
                .orElseThrow(() -> new ResourceNotFoundException("Deal non trouvé pour cet identifiant :: " + dealId));

        deal.setUtilisateur(dealDetails.getUtilisateur());
        deal.setDateDeal(dealDetails.getDateDeal());
        deal.setMontantDeal(dealDetails.getMontantDeal());
        deal.setTypeDeal(dealDetails.getTypeDeal());
        deal.setLibelleDeal(dealDetails.getLibelleDeal());

        final Deal updatedDeal = dealRepository.save(deal);
        return updatedDeal;
    }

    public void deleteDeal(Integer dealId) throws ResourceNotFoundException {
        Deal deal = dealRepository.findById(dealId)
                .orElseThrow(() -> new ResourceNotFoundException("Deal non trouvé pour cet identifiant :: " + dealId));

        dealRepository.delete(deal);
    }
}

