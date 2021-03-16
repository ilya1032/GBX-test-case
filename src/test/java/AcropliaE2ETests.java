import Responses.AuthResponses.AuthResponse;
import Responses.GenericResponses.ArrayDataResponse;
import Responses.GenericResponses.DataResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import dto.LoginForm;
import dto.NodeDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.RequestSender;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AcropliaE2ETests {

    private static LoginForm loginForm;
    private static Properties properties;

    @BeforeClass
    public static void setUp() throws IOException {

        FileInputStream propertiesFile = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/test.properties");
        properties = new Properties();
        properties.load(propertiesFile);
        loginForm = new LoginForm(
                properties.getProperty("login.email"),
                properties.getProperty("login.password")
        );
    }

    @Test
    public void loginTest() {

        TypeReference<DataResponse<AuthResponse>> dataTypeRef = new TypeReference<DataResponse<AuthResponse>>() {
        };
        DataResponse<AuthResponse> loginResponse = RequestSender.sendPostRequest(
                properties.getProperty("auth.uri"),
                "",
                "/app/session",
                loginForm,
                dataTypeRef);

        String accessToken = loginResponse.getData().getAccessToken();
        String userUUID = loginResponse.getData().getUser().getUuid();
        String libraryPath = String.format("v1/library/%s", userUUID);


        TypeReference<ArrayDataResponse<NodeDTO>> arrayTextpadTypeRef = new TypeReference<ArrayDataResponse<NodeDTO>>() {
        };
        ArrayDataResponse<NodeDTO> textPads = RequestSender.sendGetRequest(
                properties.getProperty("api.uri"),
                accessToken,
                "/v1/textpads",
                arrayTextpadTypeRef);

        int initialCount = textPads.getCount();


        String title = String.format("Textpad_%d", new Timestamp(System.currentTimeMillis()).getTime());
        NodeDTO nodeDTO = new NodeDTO("TEXTPAD", "", title);

        TypeReference<DataResponse<NodeDTO>> dataNodeTypeRef = new TypeReference<DataResponse<NodeDTO>>() {
        };
        DataResponse<NodeDTO> newTextpad = RequestSender.sendPostRequest(
                properties.getProperty("api.uri"),
                accessToken,
                libraryPath,
                nodeDTO,
                dataNodeTypeRef);

        String nodeUUID = newTextpad.getData().getUuid();


        textPads = RequestSender.sendGetRequest(
                properties.getProperty("api.uri"),
                accessToken,
                "/v1/textpads",
                arrayTextpadTypeRef);
        assertEquals(initialCount + 1, textPads.getCount());

        boolean isTextpadPresented = false;
        for (NodeDTO item : textPads.getData()) {
            if (title.equals(item.getTitle()) && nodeUUID.equals(item.getUuid())) {
                isTextpadPresented = true;
                break;
            }
        }
        assertTrue(isTextpadPresented);
    }
}
