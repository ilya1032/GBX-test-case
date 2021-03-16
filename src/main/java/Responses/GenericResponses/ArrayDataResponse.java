package Responses.GenericResponses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArrayDataResponse<T> {

    public static final String COUNT_KEY = "count";
    public static final String TOTAL_COUNT_KEY = "totalCount";
    public static final String DATA_KEY = "data";

    private List<T> data;
    private int count;
    private int totalCount;

    @JsonCreator
    public ArrayDataResponse(@JsonProperty(DATA_KEY) final List<T> data,
                             @JsonProperty(COUNT_KEY) final int count,
                             @JsonProperty(TOTAL_COUNT_KEY) final int totalCount
                             ) {
        this.data = data;
        this.count = count;
        this.totalCount = totalCount;
    }

    @JsonProperty(DATA_KEY)
    public List<T> getData() {
        return data;
    }

    @JsonProperty(DATA_KEY)
    public void setData(List<T> data) {
        this.data = data;
    }

    @JsonProperty(COUNT_KEY)
    public int getCount() {
        return count;
    }

    @JsonProperty(COUNT_KEY)
    public void setCount(int count) {
        this.count = count;
    }

    @JsonProperty(TOTAL_COUNT_KEY)
    public int getTotalCount() {
        return totalCount;
    }

    @JsonProperty(TOTAL_COUNT_KEY)
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
