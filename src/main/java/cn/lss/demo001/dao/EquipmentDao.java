package cn.lss.demo001.dao;

import cn.lss.demo001.entity.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentDao {
    public int insert(Equipment equipment);
    public int update(Equipment equipment);
    public int delete(int id);
    public Equipment searchOneById(int id);
    public List<Equipment> searchByName(String name);
    public List<Equipment> searchByTypeName(String typeName);
    public List<Equipment> searchByCity(String city);



}
