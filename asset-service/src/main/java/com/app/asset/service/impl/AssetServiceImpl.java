package com.app.asset.service.impl;

import com.app.asset.dto.*;
import com.app.asset.model.Asset;
import com.app.asset.repository.AssetRepository;
import com.app.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository repository;

    @Override
    public List<AssetRes> getAllAssets() {
        return repository.findAll().stream()
                .map(asset -> {
                    AssetRes data = new AssetRes();
                    data.setId(asset.getId());
                    data.setSerialNumber(asset.getSerialNumber());
                    data.setAssetName(asset.getAssetName());
                    data.setDescription(asset.getDescription());
                    data.setLocation(asset.getLocation());
                    data.setInUse(asset.isInUse());
                    data.setPurchasePrice(asset.getPurchasePrice());
                    data.setPurchaseDate(asset.getPurchaseDate());
                    data.setWarrantyEndDate(asset.getWarrantyEndDate());
                    data.setMaintenanceNotes(asset.getMaintenanceNotes());
                    return data;
                }).collect(Collectors.toList());
    }

    @Override
    public AssetRes getAssetById(String id) throws Exception {

        final Asset asset = repository.findAssetById(id);
        if (asset == null) {
            return null; // Return null or throw an exception as needed
        }
        AssetRes data = new AssetRes();
        data.setId(asset.getId());
        data.setSerialNumber(asset.getSerialNumber());
        data.setAssetName(asset.getAssetName());
        data.setDescription(asset.getDescription());
        data.setLocation(asset.getLocation());
        data.setInUse(asset.isInUse());
        data.setPurchasePrice(asset.getPurchasePrice());
        data.setPurchaseDate(asset.getPurchaseDate());
        data.setWarrantyEndDate(asset.getWarrantyEndDate());
        data.setMaintenanceNotes(asset.getMaintenanceNotes());

        return data;
    }

    @Override
    public AssetInsertRes createAsset(AssetInsertReq request) throws Exception {
        Asset asset = new Asset();
        asset.setSerialNumber(request.getSerialNumber());
        asset.setAssetName(request.getAssetName());
        asset.setDescription(request.getDescription());
        asset.setLocation(request.getLocation());
        asset.setInUse(request.isInUse());
        asset.setPurchasePrice(request.getPurchasePrice());
        asset.setPurchaseDate(request.getPurchaseDate());
        asset.setWarrantyEndDate(request.getWarrantyEndDate());
        asset.setMaintenanceNotes(request.getMaintenanceNotes());

        // Save the new asset to the repository
        asset = repository.save(asset);

        // Create the response
        AssetInsertRes response = new AssetInsertRes();
        response.setId(asset.getId());
        response.setMessage("Asset created successfully");

        return response;
    }

    @Override
    public AssetUpdateRes updateAsset(String id, AssetUpdateReq request) {

        Asset asset = repository.findAssetById(id);
        if (asset != null) {
            // Update asset fields based on request
            asset.setSerialNumber(request.getSerialNumber());
            asset.setAssetName(request.getAssetName());
            asset.setDescription(request.getDescription());
            asset.setLocation(request.getLocation());
            asset.setInUse(request.isInUse());
            asset.setPurchasePrice(request.getPurchasePrice());
            asset.setPurchaseDate(request.getPurchaseDate());
            asset.setWarrantyEndDate(request.getWarrantyEndDate());
            asset.setMaintenanceNotes(request.getMaintenanceNotes());

            // Save the updated asset to the repository
            repository.save(asset);

            // Create the response
            AssetUpdateRes response = new AssetUpdateRes();
            response.setId(asset.getId());
            response.setMessage("Asset updated successfully");

            return response;
        } else {
            // Return null if the asset is not found.
            return null;
        }
    }

    @Override
    public AssetDeleteRes deleteAsset(String id) {
        Asset asset = repository.findAssetById(id);
        AssetDeleteRes response = new AssetDeleteRes();

        if (asset !=null) {
            repository.deleteById(id);
            response.setId(id);
            response.setMessage("Asset deleted successfully");
        } else {
            response.setId(id);
            response.setMessage("Asset not found");
        }

        return response;
    }


}
