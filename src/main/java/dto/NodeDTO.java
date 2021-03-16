package dto;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeDTO {

    public static final String TYPE_KEY = "type";
    public static final String UUID_KEY = "uuid";
    public static final String TITLE_KEY = "title";

    private String type;
    private String uuid;
    private String title;

    @JsonCreator
    public NodeDTO(
            @JsonProperty(TYPE_KEY) final String type,
            @JsonProperty(UUID_KEY) final String uuid,
            @JsonProperty(TITLE_KEY) final String title) {
        this.type = type;
        this.uuid = uuid;
        this.title = title;
    }

    @JsonProperty(TYPE_KEY)
    public String getType() {
        return type;
    }

    @JsonProperty(TYPE_KEY)
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public String getUuid() {
        return uuid;
    }

    @JsonProperty(UUID_KEY)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty(TITLE_KEY)
    public String getTitle() {
        return title;
    }

    @JsonProperty(TITLE_KEY)
    public void setTitle(String title) {
        this.title = title;
    }
}
