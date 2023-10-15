package com.app.asset.repository;

import com.app.asset.dto.AssetRes;
import com.app.asset.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {

    @Query(value = " SELECT * FROM asset a " +
            " WHERE a.id = ?1", nativeQuery = true)
    Asset findAssetById(String id);

}
