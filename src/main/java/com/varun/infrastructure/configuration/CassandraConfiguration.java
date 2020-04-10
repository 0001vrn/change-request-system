package com.varun.infrastructure.configuration;

import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.varun.infrastructure.repository.SpringDataCassandraChgRequestRepository;

@EnableCassandraRepositories(basePackageClasses = SpringDataCassandraChgRequestRepository.class)
public class CassandraConfiguration {
}
