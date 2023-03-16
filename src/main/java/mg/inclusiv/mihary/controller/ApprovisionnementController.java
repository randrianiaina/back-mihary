package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.entity.Approvisionnement;
import mg.inclusiv.mihary.service.ApprovisionnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    private ApprovisionnementService approvisionnementService;
    @GetMapping("/list")
    public List<Approvisionnement> getAllApprovisionnements() {
        return approvisionnementService.approvisionnementList();
    }
    @PostMapping("/new")
    public Approvisionnement saveApprovisionnement(@RequestBody Approvisionnement approvisionnement) {
        return approvisionnementService.saveApprovisionnement(approvisionnement);
    }
    @DeleteMapping("/{id}")
    public void deleteApprovisionnementById(@PathVariable Long id) {
        approvisionnementService.deleteApprovisionnement(id);
    }

}
