package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class BuddyInfoController {
//    @PostMapping("/AddressBook")
//    public String postBuddyInfo(@ModelAttribute BuddyInfo bi) {
//        return "result";
//    }
//
//}


import org.springframework.ui.Model;

@Controller
public class BuddyInfoController {

    @ResponseBody
    @GetMapping("/book")
    public BuddyInfo book(@RequestParam(name = "name", required=false, defaultValue = "NoName") String name, Model model) {

        model.addAttribute("name", name);
        model.addAttribute("phoneNumber", "phoneNumber");
        model.addAttribute("address", "address");
        return new BuddyInfo(name, "123 lane dr", "555-5555");
    }
    @Autowired
    private BuddyInfoRepository repository;


    @GetMapping("buddyinfo/add")
    public String getSubmitForm(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "submitForm";
    }

    @PostMapping("buddyinfo/add")
    public String submit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        System.out.println(buddyInfo.toString());
        repository.save(buddyInfo);
        return displayAddressBookList(model);
    }


    @GetMapping("/buddyinfo")
    public String displayAddressBookList(Model model) {
        model.addAttribute("buddyInfoList", repository.findAll());
        return "AddressBook";
    }
}

