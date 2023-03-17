package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deals")
public class DealController {

        @Autowired
        private DealService dealService;

        @GetMapping("")
        public List<Deal> getAllDeals() {
                return dealService.getAllDeals();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Deal> getDealById(@PathVariable(value = "id") Integer dealId)
                throws ResourceNotFoundException {
                Deal deal = dealService.getDealById(dealId)
                        .orElseThrow(() -> new ResourceNotFoundException("Deal non trouvé pour cet identifiant :: " + dealId));
                return ResponseEntity.ok().body(deal);
        }

        @PostMapping("")
        public Deal createDeal(@Valid @RequestBody Deal deal) {
                return dealService.saveDeal(deal);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Deal> updateDeal(@PathVariable(value = "id") Integer dealId,
                                               @Valid @RequestBody Deal dealDetails) throws ResourceNotFoundException {
                Deal updatedDeal = dealService.updateDeal(dealId, dealDetails);
                return ResponseEntity.ok(updatedDeal);
        }

        @DeleteMapping("/{id}")
        public Map<String, Boolean> deleteDeal(@PathVariable(value = "id") Integer dealId)
                throws ResourceNotFoundException {
                dealService.deleteDeal(dealId);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return response;
        }
}
