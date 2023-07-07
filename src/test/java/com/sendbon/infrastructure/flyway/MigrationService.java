package com.sendbon.infrastructure.flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.flywaydb.core.Flyway;

@ApplicationScoped
public class MigrationService {
    private static final Logger logger = LoggerFactory.getLogger(MigrationService.class);

      // You can Inject the object if you want to use it manually
      @Inject
      Flyway flyway; 
  
      public void checkMigration() {
          // This will print 1.0.0
          logger.info("Flyway version: " + flyway.info().current().getVersion().toString());
      }
}
