package mg.inclusiv.mihary.controller;

import mg.inclusiv.mihary.entity.Qualite;
import mg.inclusiv.mihary.service.QualiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/qualite")
public class QualiteController {
    QualiteService qualiteService;

    @GetMapping("showList")
    public List<Qualite> qualiteList(){
        return qualiteService.listAll();
    }

//    @RequestMapping("/")
//    public String viewHomePage(Model model){
//        List<Qualite> qualiteList = qualiteService.listAll();
//        model.addAttribute("qualiteList", qualiteList);
//        return "index";
//    }

}
