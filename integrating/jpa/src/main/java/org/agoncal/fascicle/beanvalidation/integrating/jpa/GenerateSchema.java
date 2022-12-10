package org.agoncal.fascicle.beanvalidation.integrating.jpa;

import jakarta.persistence.Persistence;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class GenerateSchema {

  public static void main(String[] args) {

    Persistence.generateSchema("beanvalidationPU", null);
    System.exit(0);
  }
}
