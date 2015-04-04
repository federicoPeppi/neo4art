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

package org.neo4art.domain;

/**
 * @author Lorenzo Speranzoni
 * @since 4 Apr 2015
 */
public class ArtMovement {

  private String name;
  private String image;
  private String imageSize;
  private String alt;
  private String caption;
  private String yearsActive;
  private String country;
  private String majorFigures;
  private String influences;
  private String influenced;
  
  public ArtMovement() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImageSize() {
    return imageSize;
  }

  public void setImageSize(String imageSize) {
    this.imageSize = imageSize;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getYearsActive() {
    return yearsActive;
  }

  public void setYearsActive(String yearsActive) {
    this.yearsActive = yearsActive;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getMajorFigures() {
    return majorFigures;
  }

  public void setMajorFigures(String majorFigures) {
    this.majorFigures = majorFigures;
  }

  public String getInfluences() {
    return influences;
  }

  public void setInfluences(String influences) {
    this.influences = influences;
  }

  public String getInfluenced() {
    return influenced;
  }

  public void setInfluenced(String influenced) {
    this.influenced = influenced;
  }
}
