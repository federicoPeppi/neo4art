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

package deprecated;

/**
 * @author Lorenzo Speranzoni
 * @since 29 Mar 2015
 */
@Deprecated
public class Neo4ArtGraphDatabase {

  public static final String NEO4J_STORE_DIR = System.getenv("NEO4J_STORE_DIR") != null ? System.getenv("NEO4J_STORE_DIR") : "target/graph.db";

  public static final String NEO4J_PATH = System.getenv("NEO4J_PATH") != null ? System.getenv("NEO4J_PATH") : "jdbc:neo4j:file:" + NEO4J_STORE_DIR;
  
  public static final String NEO4J_URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL") : "http://localhost:7474";
  public static final String NEO4J_USR = System.getenv("NEO4J_USR") != null ? System.getenv("NEO4J_USR") : "neo4j";
  public static final String NEO4J_PWD = System.getenv("NEO4J_PWD") != null ? System.getenv("NEO4J_PWD") : "neo4art";
}