package com.example.catalog.service;

import org.springframework.stereotype.Service;

import com.example.catalog.jpa.CatalogEntity;
import com.example.catalog.jpa.CatalogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository repository;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return repository.findAll();
    }

}
