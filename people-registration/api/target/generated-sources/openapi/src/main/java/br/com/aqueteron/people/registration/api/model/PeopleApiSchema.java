package br.com.aqueteron.people.registration.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PeopleApiSchema
 */

@JsonTypeName("People")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.13.0")
public class PeopleApiSchema implements Serializable {

  private static final long serialVersionUID = 1L;

  private @Nullable String id;

  private @Nullable String nome;

  private @Nullable String sobrenome;

  private @Nullable Integer idade;

  private @Nullable String pais;

  public PeopleApiSchema id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, example = "84736dce-3bbb-4689-83aa-575271600047", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PeopleApiSchema nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   */
  
  @Schema(name = "nome", example = "Maria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public PeopleApiSchema sobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
    return this;
  }

  /**
   * Get sobrenome
   * @return sobrenome
   */
  
  @Schema(name = "sobrenome", example = "Aparecida dos Santos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sobrenome")
  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public PeopleApiSchema idade(Integer idade) {
    this.idade = idade;
    return this;
  }

  /**
   * Get idade
   * @return idade
   */
  
  @Schema(name = "idade", example = "37", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idade")
  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public PeopleApiSchema pais(String pais) {
    this.pais = pais;
    return this;
  }

  /**
   * Get pais
   * @return pais
   */
  
  @Schema(name = "pais", example = "Brasil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pais")
  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeopleApiSchema people = (PeopleApiSchema) o;
    return Objects.equals(this.id, people.id) &&
        Objects.equals(this.nome, people.nome) &&
        Objects.equals(this.sobrenome, people.sobrenome) &&
        Objects.equals(this.idade, people.idade) &&
        Objects.equals(this.pais, people.pais);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, sobrenome, idade, pais);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeopleApiSchema {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    sobrenome: ").append(toIndentedString(sobrenome)).append("\n");
    sb.append("    idade: ").append(toIndentedString(idade)).append("\n");
    sb.append("    pais: ").append(toIndentedString(pais)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

