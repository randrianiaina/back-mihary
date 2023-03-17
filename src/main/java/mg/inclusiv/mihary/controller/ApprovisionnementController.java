package mg.inclusiv.mihary.controller;


import mg.inclusiv.mihary.entity.Approvisionnement;
import mg.inclusiv.mihary.service.ApprovisionnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/approvisionnements")
public class ApprovisionnementController {

    @Autowired
    private ApprovisionnementService approvisionnementService;

    @GetMapping("")
    public List<Approvisionnement> getAllApprovisionnements() {
        return approvisionnementService.getAllApprovisionnements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approvisionnement> getApprovisionnementById(@PathVariable(value = "id") Long approvisionnementId)
            throws ResourceNotFoundException {
        Approvisionnement approvisionnement = approvisionnementService.getApprovisionnementById(approvisionnementId);
        return ResponseEntity.ok().body(approvisionnement);
    }

    @PostMapping("")
    public Approvisionnement createApprovisionnement(@Valid @RequestBody Approvisionnement approvisionnement) {
        return approvisionnementService.saveApprovisionnement(approvisionnement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approvisionnement> updateApprovisionnement(@PathVariable(value = "id") Long approvisionnementId,
                                                                     @Valid @RequestBody Approvisionnement approvisionnementDetails) throws ResourceNotFoundException {
        Approvisionnement updatedApprovisionnement = approvisionnementService.updateApprovisionnement(approvisionnementId, approvisionnementDetails);
        return ResponseEntity.ok(updatedApprovisionnement);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteApprovisionnement(@PathVariable(value = "id") Long approvisionnementId)
            throws ResourceNotFoundException {
        approvisionnementService.deleteApprovisionnement(approvisionnementId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
