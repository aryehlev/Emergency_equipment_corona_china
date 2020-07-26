package cn.lss.demo001.ajax;

import cn.lss.demo001.dao.impl.EquipmentDaoImpl;
import cn.lss.demo001.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ajax/equipment")
public class EquipmentAjax {
    @Autowired
    private EquipmentDaoImpl equipmentDao;

    @RequestMapping("/insert")
    public Map<String, Object> equipmentInsert(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(request.getParameter("e_name"));
        System.out.println(request.getParameter("e_typeName"));
        System.out.println(request.getParameter("lobgitude"));
        System.out.println(Double.parseDouble(request.getParameter("latitude")));
        String name = request.getParameter("e_name");
        String categoryName = request.getParameter("e_typeName");
        double lobgitude= Double.parseDouble(request.getParameter("lobgitude"));
        double latitude= Double.parseDouble(request.getParameter("latitude"));
        System.out.println(name);
        System.out.println(categoryName);
        System.out.println(lobgitude);
        System.out.println(latitude);
        Equipment equipment = new Equipment(name,categoryName,lobgitude,latitude);
        System.out.println(equipment);
        int num = equipmentDao.insert(equipment);
        if (num != 0) {
            map.put("status", "success");
        } else {
            map.put("status", "error");
        }
        return map;

    }

    @RequestMapping("/update")
    public Map<String, Object> equipmentUpdate(Equipment equipment) {
        Map<String, Object> map = new HashMap<>();
        int num = equipmentDao.update(equipment);
        if (num != 0) {
            map.put("status", "success");
        } else {
            map.put("status", "error");
        }

        return map;

    }

    @RequestMapping("/search")
    public Map<String, Object> search(String keyword) {
        Map<String, Object> map = new HashMap<>();
        List<Equipment> equipment = equipmentDao.searchByName(keyword);
        if (equipment.isEmpty()) {
            List<Equipment> equipment1 = equipmentDao.searchByCity(keyword);
            if (equipment1.isEmpty()) {
                List<Equipment> equipment2 = equipmentDao.searchByCity(keyword);
                if (equipment2.isEmpty()) {
                    map.put("status", "error");
                } else {
                    map.put("status", "success");
                    map.put("data", equipment2);
                }
            } else {
                map.put("status", "success");
                map.put("data", equipment1);
            }
        } else {
            map.put("status", "success");

            map.put("data", equipment);
        }

        return map;
    }

}
