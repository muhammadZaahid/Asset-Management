package com.app.asset.service;

import com.app.asset.model.Asset;
import com.app.asset.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetById(String id) {
        return assetRepository.findById(id);
    }

    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAsset(String id, Asset asset) {
        if (assetRepository.existsById(id)) {
            asset.setId(id);
            return assetRepository.save(asset);
        }
        return null; // Handle error or validation as needed
    }

    public ResponseEntity<?> deleteAsset(String id) {
        if (assetRepository.existsById(id)) {
            assetRepository.deleteById(id);
            return ResponseEntity.ok("Asset deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asset not found");
    }
}
