/*
 * RSS Feed Aggregator
 * This is an api for \"RSS Feed Aggregator\".  [View Subject](https://intra.epitech.eu/module/2016/M-EAP-650/PAR-9-1/acti-235029/project/file/RSS-feed-aggregator.pdf) or [Messenger group](https://www.messenger.com/t/552069568251252)  A successfull login or signup generate a key usable to authenticate request  This key is owned by one account, a request providing an apiKey should get result for the user owning this key. 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Feed
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-01-26T20:43:45.780Z")
public class Feed   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("copyright")
  private String copyright = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docs")
  private String docs = null;

  @JsonProperty("generator")
  private String generator = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("lastBuildDate")
  private String lastBuildDate = null;

  @JsonProperty("link")
  private String link = null;

  @JsonProperty("managingEditor")
  private String managingEditor = null;

  @JsonProperty("pubDate")
  private String pubDate = null;

  @JsonProperty("rating")
  private String rating = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("webMaster")
  private String webMaster = null;

  public Feed id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Feed url(String url) {
    this.url = url;
    return this;
  }

   /**
   * url to download feed
   * @return url
  **/
  @JsonProperty("url")
  @ApiModelProperty(required = true, value = "url to download feed")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Feed category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @JsonProperty("category")
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Feed copyright(String copyright) {
    this.copyright = copyright;
    return this;
  }

   /**
   * Get copyright
   * @return copyright
  **/
  @JsonProperty("copyright")
  @ApiModelProperty(value = "")
  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public Feed description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @JsonProperty("description")
  @ApiModelProperty(required = true, value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Feed docs(String docs) {
    this.docs = docs;
    return this;
  }

   /**
   * Get docs
   * @return docs
  **/
  @JsonProperty("docs")
  @ApiModelProperty(value = "")
  public String getDocs() {
    return docs;
  }

  public void setDocs(String docs) {
    this.docs = docs;
  }

  public Feed generator(String generator) {
    this.generator = generator;
    return this;
  }

   /**
   * Get generator
   * @return generator
  **/
  @JsonProperty("generator")
  @ApiModelProperty(value = "")
  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }

  public Feed image(String image) {
    this.image = image;
    return this;
  }

   /**
   * Get image
   * @return image
  **/
  @JsonProperty("image")
  @ApiModelProperty(value = "")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Feed language(String language) {
    this.language = language;
    return this;
  }

   /**
   * ISO_639-1 language code
   * @return language
  **/
  @JsonProperty("language")
  @ApiModelProperty(value = "ISO_639-1 language code")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Feed lastBuildDate(String lastBuildDate) {
    this.lastBuildDate = lastBuildDate;
    return this;
  }

   /**
   * Get lastBuildDate
   * @return lastBuildDate
  **/
  @JsonProperty("lastBuildDate")
  @ApiModelProperty(value = "")
  public String getLastBuildDate() {
    return lastBuildDate;
  }

  public void setLastBuildDate(String lastBuildDate) {
    this.lastBuildDate = lastBuildDate;
  }

  public Feed link(String link) {
    this.link = link;
    return this;
  }

   /**
   * url of blog corresponding to feed
   * @return link
  **/
  @JsonProperty("link")
  @ApiModelProperty(required = true, value = "url of blog corresponding to feed")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Feed managingEditor(String managingEditor) {
    this.managingEditor = managingEditor;
    return this;
  }

   /**
   * Get managingEditor
   * @return managingEditor
  **/
  @JsonProperty("managingEditor")
  @ApiModelProperty(value = "")
  public String getManagingEditor() {
    return managingEditor;
  }

  public void setManagingEditor(String managingEditor) {
    this.managingEditor = managingEditor;
  }

  public Feed pubDate(String pubDate) {
    this.pubDate = pubDate;
    return this;
  }

   /**
   * Get pubDate
   * @return pubDate
  **/
  @JsonProperty("pubDate")
  @ApiModelProperty(value = "")
  public String getPubDate() {
    return pubDate;
  }

  public void setPubDate(String pubDate) {
    this.pubDate = pubDate;
  }

  public Feed rating(String rating) {
    this.rating = rating;
    return this;
  }

   /**
   * Get rating
   * @return rating
  **/
  @JsonProperty("rating")
  @ApiModelProperty(value = "")
  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public Feed title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @JsonProperty("title")
  @ApiModelProperty(required = true, value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Feed webMaster(String webMaster) {
    this.webMaster = webMaster;
    return this;
  }

   /**
   * Get webMaster
   * @return webMaster
  **/
  @JsonProperty("webMaster")
  @ApiModelProperty(value = "")
  public String getWebMaster() {
    return webMaster;
  }

  public void setWebMaster(String webMaster) {
    this.webMaster = webMaster;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feed feed = (Feed) o;
    return Objects.equals(this.id, feed.id) &&
        Objects.equals(this.url, feed.url) &&
        Objects.equals(this.category, feed.category) &&
        Objects.equals(this.copyright, feed.copyright) &&
        Objects.equals(this.description, feed.description) &&
        Objects.equals(this.docs, feed.docs) &&
        Objects.equals(this.generator, feed.generator) &&
        Objects.equals(this.image, feed.image) &&
        Objects.equals(this.language, feed.language) &&
        Objects.equals(this.lastBuildDate, feed.lastBuildDate) &&
        Objects.equals(this.link, feed.link) &&
        Objects.equals(this.managingEditor, feed.managingEditor) &&
        Objects.equals(this.pubDate, feed.pubDate) &&
        Objects.equals(this.rating, feed.rating) &&
        Objects.equals(this.title, feed.title) &&
        Objects.equals(this.webMaster, feed.webMaster);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, url, category, copyright, description, docs, generator, image, language, lastBuildDate, link, managingEditor, pubDate, rating, title, webMaster);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feed {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docs: ").append(toIndentedString(docs)).append("\n");
    sb.append("    generator: ").append(toIndentedString(generator)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    lastBuildDate: ").append(toIndentedString(lastBuildDate)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    managingEditor: ").append(toIndentedString(managingEditor)).append("\n");
    sb.append("    pubDate: ").append(toIndentedString(pubDate)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    webMaster: ").append(toIndentedString(webMaster)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

