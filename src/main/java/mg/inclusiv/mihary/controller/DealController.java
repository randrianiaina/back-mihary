package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.entity.Deal;
import mg.inclusiv.mihary.Service.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Deal")
public class DealController {
        public DealService dealService;
        @GetMapping("/list")
        public List<Deal> dealList(){
            return dealService.dealList();
        }
        @PostMapping("/addDeal")
        public void ajouterDeal(@RequestBody Deal deal){
            dealService.save(deal);
        }
        @DeleteMapping("/deleteDeal/{id}")
        public void supprimerDeal(@PathVariable ("id")Integer id){
                dealService.delete(id);}





}
