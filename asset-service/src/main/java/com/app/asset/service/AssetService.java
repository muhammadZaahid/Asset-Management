package com.app.asset.service;

import com.app.asset.dto.*;
import java.util.List;

public interface AssetService {

    List<AssetRes> getAllAssets() throws Exception;

    AssetRes getAssetById(String id) throws Exception;

    AssetInsertRes createAsset(AssetInsertReq request) throws Exception;

    AssetUpdateRes updateAsset(String id, AssetUpdateReq request);

    AssetDeleteRes deleteAsset(String id);
}
