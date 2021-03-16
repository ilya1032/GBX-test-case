package Responses.AuthResponses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dto.PrivateUserDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {

    public static final String ACCESS_KEY = "accessToken";
    public static final String REFRESH_KEY = "refreshToken";
    public static final String SECRET_KEY = "secret";
    public static final String USER_KEY = "user";

    private String accessToken;
    private String refreshToken;
    private String secret;
    private PrivateUserDTO user;

    @JsonCreator
    public AuthResponse(
            @JsonProperty(ACCESS_KEY) final String accessToken,
            @JsonProperty(REFRESH_KEY) final String refreshToken,
            @JsonProperty(SECRET_KEY) final String secret,
            @JsonProperty(USER_KEY) final PrivateUserDTO user) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.secret = secret;
        this.user = user;
    }

    @JsonProperty(ACCESS_KEY)
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty(ACCESS_KEY)
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty(REFRESH_KEY)
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty(REFRESH_KEY)
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty(SECRET_KEY)
    public String getSecret() {
        return secret;
    }

    @JsonProperty(SECRET_KEY)
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @JsonProperty(USER_KEY)
    public PrivateUserDTO getUser() {
        return user;
    }

    @JsonProperty(USER_KEY)
    public void setUser(PrivateUserDTO user) {
        this.user = user;
    }
}
