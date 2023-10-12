package com.app.asset.controller;

import com.app.asset.model.Asset;
import com.app.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public Optional<Asset> getAssetById(@PathVariable String id) {
        return assetService.getAssetById(id);
    }

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    @PutMapping("/{id}")
    public Asset updateAsset(@PathVariable String id, @RequestBody Asset asset) {
        return assetService.updateAsset(id, asset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable String id) {
        return assetService.deleteAsset(id);
    }
}
