//package com.vsb.vea.project.bussinesslayer;
//
//import com.vsb.vea.project.dao.CarrierDao;
//import com.vsb.vea.project.dao.DaoFactory;
//import com.vsb.vea.project.dto.Carrier;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CarrierService {
//    private CarrierDao carrierDao;
//
//    @Autowired
//    public void setDaoFactory(DaoFactory factory) {
//        carrierDao = factory.getCarrierDao();
//    }
//    public List<Carrier> getAllCarriers() {
//        return carrierDao.getAll();
//    }
//}
