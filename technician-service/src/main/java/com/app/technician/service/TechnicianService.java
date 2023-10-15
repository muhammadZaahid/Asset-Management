package com.app.technician.service;

import com.app.asset.dto.AssetDeleteRes;
import com.app.technician.dto.BaseRes;
import com.app.technician.dto.TechnicianInsertReq;
import com.app.technician.dto.TechnicianRes;
import com.app.technician.dto.TechnicianUpdateReq;
import com.app.technician.model.Technician;
import com.app.technician.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TechnicianService {

    BaseRes createTechnician(TechnicianInsertReq request);

    List<TechnicianRes> getAllTechnicians();

    TechnicianRes getTechnicianById(String id);

    BaseRes updateTechnician(String id, TechnicianUpdateReq request);

    BaseRes deleteTechnician(String id);
}
