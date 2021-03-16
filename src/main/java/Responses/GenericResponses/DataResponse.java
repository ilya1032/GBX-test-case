package Responses.GenericResponses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse <T> {

    public static final String DATA_KEY = "data";

    private T data;

    @JsonCreator
    public DataResponse(
            @JsonProperty(DATA_KEY) final T data) {
        this.data = data;
    }

    @JsonProperty(DATA_KEY)
    public T getData() {
        return data;
    }

    @JsonProperty(DATA_KEY)
    public void setData(T data) {
        this.data = data;
    }
}
