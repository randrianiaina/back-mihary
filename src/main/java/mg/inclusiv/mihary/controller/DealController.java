package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealController {
        @Autowired
        public DealService dealService;
        @GetMapping("/list")
        public List<Deal> dealList(){
            return dealService.dealList();
        }
        @PostMapping("/add")
        public void ajouterDeal(@RequestBody Deal deal){
            dealService.save(deal);
        }
        @DeleteMapping("/delete/{id}")
        public void supprimerDeal(@PathVariable ("id")Integer id){
                dealService.delete(id);}





}
