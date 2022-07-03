package by.yarosh.shop.service;

import by.yarosh.shop.domain.Bucket;
import by.yarosh.shop.domain.User;
import by.yarosh.shop.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user , List<Long> productsIds);
    void addProducts(Bucket bucket, List<Long> productsIds);

    BucketDTO getBucketByUser(String name);
}
