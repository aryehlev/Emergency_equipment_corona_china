package cn.lss.demo001.controller;

import cn.lss.demo001.dao.EquipmentDao;
import cn.lss.demo001.entity.Equipment;
import cn.lss.demo001.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EquipmentController {
    @Autowired
    EquipmentDao equipmentDao;

    @RequestMapping("/fine")
    public String fine(Model model, String name) {
        System.out.println("123");
        List<Equipment> equipmentlist = search(name);
        List<Point> list = new ArrayList<>();
        if (name != null) {
//            List<Point> points = new ArrayList<>();
//            for (Equipment equipment : equipmentlist) {
//                if(equipment.getAvailable() == 0)
//                    continue;
//                Point point = new Point(equipment.getLongitude(), equipment.getLatitude());
//                list.add(point);
//
//            }

            List<Equipment> points = new ArrayList<>();
            for (Equipment equipment : equipmentlist) {
                if(equipment.getAvailable() == 0)
                    continue;

                points.add(equipment);

            }
            System.out.println(list.toString());
            model.addAttribute("list", points);
        }
        return "/index/one";
    }

    @RequestMapping("/one")
    public String One() {
        return "/index/one";
    }

    @RequestMapping("/fire")
    public String Fire() {
        return "/index/fire";
    }

    @RequestMapping("/Fire detction")
    public String FireDetction() {
        return "/index/Fire detction";
    }

    @RequestMapping("/Demolitiontool")
    public String Demolitiontool() {
        return "/index/Demolitiontool";
    }

    @RequestMapping("/two")
    public String Two(Model model) {
        model.addAttribute("src","Demolitiontool");
        return "/index/two";
    }

    @RequestMapping("/change")
    public String change(Model model,String name) {
        switch (name){
            case "a":
                model.addAttribute("src","fire");
                break;
            case "b":
                model.addAttribute("src","Fire detction");
                break;
            case "c":
                model.addAttribute("src","Demolitiontool");
                break;
            default:
                break;
        }
        return "/index/two";
    }

    public List<Equipment> search(String keyword) {

        List<Equipment> equipment = equipmentDao.searchByName(keyword);
        List<Equipment> data = new ArrayList<>();
        if (equipment.isEmpty()) {
            List<Equipment> equipment1 = equipmentDao.searchByCity(keyword);
            if (equipment1.isEmpty()) {
                List<Equipment> equipment2 = equipmentDao.searchByCity(keyword);
                if (equipment2.isEmpty()) {
                    return null;
                } else {

                    data = equipment2;
                }
            } else {
                data = equipment1;
            }
        } else {

            data = equipment;
        }

        return data;
    }
}
