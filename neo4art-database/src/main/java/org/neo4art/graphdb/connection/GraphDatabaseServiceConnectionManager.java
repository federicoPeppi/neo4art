/**
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.neo4art.graphdb.connection;

import org.neo4art.graphdb.Index;
import org.neo4art.graphdb.Node;
import org.neo4art.graphdb.Relationship;
import org.neo4art.graphdb.indexes.HashMapIndex;
import org.neo4art.graphdb.indexes.IndexAlreadyExistsException;
import org.neo4art.graphdb.indexes.IndexNotFoundException;
import org.neo4art.graphdb.transaction.GraphDatabaseTransaction;
import org.neo4art.graphdb.transaction.TransactionWrapper;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * @author Lorenzo Speranzoni
 * @since 19 Oct 2015
 */
class GraphDatabaseServiceConnectionManager implements GraphDatabaseConnectionManager {
  
  private static GraphDatabaseService graphDatabaseService;
  
  protected GraphDatabaseServiceConnectionManager() {
    
    newGraphDatabaseServiceInstance();
  }
  
  private void newGraphDatabaseServiceInstance() {
    
    if (graphDatabaseService == null)
      graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(NEO4J_STORE_DIR);
  }
  
  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#getStoreDir()
   */
  @Override
  public String getStoreDir() {
    
    return NEO4J_STORE_DIR;
  }

  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#close()
   */
  @Override
  public void close() {
    
    graphDatabaseService.shutdown();
  }

  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#createNode(org.neo4art.graphdb.Node)
   */
  @Override
  public long createNode(Node node) {
    
    org.neo4j.graphdb.Node neo4jNode = graphDatabaseService.createNode(node.getLabels());
    
    for (String key : node.getProperties().keySet()) {
      neo4jNode.setProperty(key, node.getProperties().get(key));
    }
    
    return neo4jNode.getId();
  }

  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#createRelationship(org.neo4art.graphdb.Relationship)
   */
  @Override
  public long createRelationship(Relationship relationship) {
    
    return 0;
  }

  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#createIndex(java.lang.String)
   */
  @Override
  @SuppressWarnings("rawtypes")
  public Index createIndex(String name) throws IndexAlreadyExistsException {
    
    return new HashMapIndex<String, Long>(name);
  }

  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#getIndex(java.lang.String)
   */
  @Override
  @SuppressWarnings("rawtypes")
  public Index getIndex(String name) throws IndexNotFoundException {
    
    return new HashMapIndex<String, Long>(name);
  }
  
  /**
   * @see org.neo4art.graphdb.connection.GraphDatabaseConnectionManager#getTransactionManager()
   */
  @Override
  public GraphDatabaseTransaction getTransactionManager() {

    return new TransactionWrapper(graphDatabaseService);
  }
}