package com.app.asset.service;

import com.app.asset.dto.*;
import com.app.asset.model.Asset;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AssetService {

    public List<AssetRes> getAllAssets() throws Exception;

    public AssetRes getAssetById(String id) throws Exception;

    public AssetInsertRes createAsset(AssetInsertReq request) throws Exception;

    AssetUpdateRes updateAsset(String id, AssetUpdateReq request);

    AssetDeleteRes deleteAsset(String id);
}
