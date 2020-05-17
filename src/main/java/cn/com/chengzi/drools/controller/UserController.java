package cn.com.chengzi.drools.controller;

import cn.com.chengzi.drools.domain.model.Customer;
import cn.com.chengzi.drools.domain.model.User;
import cn.com.chengzi.drools.service.UserService;
import lombok.AllArgsConstructor;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    private KieSession kieSession;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        boolean result = userService.save(user);
        kieSession.insert(user.getName());
        kieSession.insert(user);
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("contains"));
        return String.valueOf(result);
    }
}
