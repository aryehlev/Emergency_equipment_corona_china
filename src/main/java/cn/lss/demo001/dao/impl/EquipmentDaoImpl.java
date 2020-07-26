package cn.lss.demo001.dao.impl;

import cn.lss.demo001.dao.EquipmentDao;
import cn.lss.demo001.dao.StudentDao;
import cn.lss.demo001.entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentDaoImpl implements EquipmentDao {
    @Autowired
    private EquipmentDao equipmentDao;
    @Override
    public int insert(Equipment equipment) {
        int num = equipmentDao.insert(equipment);
        return num;
    }

    @Override
    public int update(Equipment equipment) {
        int num = equipmentDao.update(equipment);
        return num;
    }

    @Override
    public Equipment searchOneById(int id) {
        Equipment equipment = equipmentDao.searchOneById(id);
        return equipment;
    }

    @Override
    public int delete(int id) {
        int num = equipmentDao.delete(id);
        return num;
    }

    @Override
    public List<Equipment> searchByName(String name) {
        List<Equipment> equipments= equipmentDao.searchByName(name);
        return equipments;
    }

    @Override
    public List<Equipment> searchByTypeName(String TypeName) {
        List<Equipment> equipments= equipmentDao.searchByTypeName(TypeName);
        return equipments;
    }


    @Override
    public List<Equipment> searchByCity(String City) {
        List<Equipment> equipments= equipmentDao.searchByCity(City);
        return equipments;
    }
}
