package com.app.asset.controller;

import com.app.asset.dto.*;
import com.app.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<List<AssetRes>> getAllAssets() throws Exception {

        final List<AssetRes> response = assetService.getAllAssets();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetRes> getAssetById(@PathVariable String id) throws Exception {
        final AssetRes response = assetService.getAssetById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssetInsertRes> createAsset(@RequestBody AssetInsertReq request) throws Exception {
        AssetInsertRes response = assetService.createAsset(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetUpdateRes> updateAsset(@PathVariable String id, @RequestBody AssetUpdateReq request) throws Exception {
        AssetUpdateRes response = assetService.updateAsset(id, request);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssetDeleteRes> deleteAsset(@PathVariable String id) {
        AssetDeleteRes response = assetService.deleteAsset(id);

        if (response.getMessage().equals("Asset deleted successfully")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
