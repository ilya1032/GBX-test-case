package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrivateUserDTO {

    public static final String ID_KEY = "id";
    public static final String UUID_KEY = "uuid";
    public static final String EMAIL_KEY = "email";

    private String id;
    private String uuid;
    private String email;

    @JsonCreator
    public PrivateUserDTO(
            @JsonProperty(ID_KEY) final String id,
            @JsonProperty(UUID_KEY) final String uuid,
            @JsonProperty(EMAIL_KEY) final String email) {
        this.id = id;
        this.uuid = uuid;
        this.email = email;
    }

    @JsonProperty(ID_KEY)
    public String getId() {
        return id;
    }

    @JsonProperty(ID_KEY)
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty(UUID_KEY)
    public String getUuid() {
        return uuid;
    }

    @JsonProperty(UUID_KEY)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty(EMAIL_KEY)
    public String getEmail() {
        return email;
    }

    @JsonProperty(EMAIL_KEY)
    public void setEmail(String email) {
        this.email = email;
    }
}
