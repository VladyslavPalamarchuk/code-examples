package com.example.codeexamples.elasticsearch.repository;

import org.testcontainers.elasticsearch.ElasticsearchContainer;

public class ProductElasticsearchContainer extends ElasticsearchContainer {

    private static final String ELASTIC_SEARCH_DOCKER = "elasticsearch:6.4.3";

    private static final String CLUSTER_NAME = "cluster.name";

    private static final String ELASTIC_SEARCH = "elasticsearch";

    public ProductElasticsearchContainer() {
        super(ELASTIC_SEARCH_DOCKER);
        this.addFixedExposedPort(9201, 9201);
        this.addFixedExposedPort(9301, 9301);
        this.addEnv(CLUSTER_NAME, ELASTIC_SEARCH);
    }
}
