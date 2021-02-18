package spring_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_crud.dao.UserDao;
import spring_crud.model.User;

@Controller
@RequestMapping("/jm-spring")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/view")
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        return "jm-spring/index";
    }

    @GetMapping()
    public String welcome(){
        return "jm-spring/welcome";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "jm-spring/show";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "jm-spring/new";
    }

    @PostMapping()
    public  String create (@ModelAttribute("user") User user){
        userDao.create(user);
        return "redirect:/jm-spring/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userDao.show(id));
        return "jm-spring/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userDao.update(id, user);
        return "redirect:/jm-spring/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userDao.delete(id);
        return "redirect:/jm-spring/";
    }


}
