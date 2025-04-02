package Automatisation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XRayFeatureUploader {

    private static final String XRAY_API_URL = "https://xray.cloud.getxray.app/api/v2/authenticate";
    private static final String XRAY_EXPORT_ZIP_URL = "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=";
    private static final String XRAY_RESULTS_URL = "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber";
    private static final String CLIENT_ID = "723565485D034E88A38F489D94D11E17";
    private static final String CLIENT_SECRET = "49061d773899f0f538536b49bc60d517787c8c591d3f68efab6de36728aa8761";

    public static String generateToken() {
        JSONObject authPayload = new JSONObject();
        authPayload.put("client_id", CLIENT_ID);
        authPayload.put("client_secret", CLIENT_SECRET);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(authPayload.toString())
                .post(XRAY_API_URL);

        if (response.statusCode() == 200) {
            return response.getBody().asString().replace("\"", "");
        } else {
            throw new RuntimeException("Failed to generate token: " + response.getBody().asString());
        }
    }

    public static void GetFeatures(String token, String testKey, String outputZipPath) throws IOException {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(XRAY_EXPORT_ZIP_URL + testKey);

        if (response.statusCode() == 200) {
            try (InputStream inputStream = response.asInputStream();
                 FileOutputStream outputStream = new FileOutputStream(outputZipPath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Feature files saved as ZIP: " + outputZipPath);
        } else {
            System.out.println("Failed to download feature files: " + response.getBody().asString());
        }
    }

    public static void unzipFile(String zipFilePath, String destDir) throws IOException {
        File destDirectory = new File(destDir);
        if (!destDirectory.exists()) {
            destDirectory.mkdirs();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                File newFile = new File(destDir, entry.getName());
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
                zipInputStream.closeEntry();
            }
        }
        System.out.println("Feature files extracted to: " + destDir);
    }

    public static void sendTestResultsToXray(String token, String testExecutionData) {

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(testExecutionData)
                .post(XRAY_RESULTS_URL);

        if (response.statusCode() == 200) {
            System.out.println("Test results sent successfully: " + response.getBody().asString());
        } else {
            System.out.println("Failed to send test results: " + response.getBody().asString());
            System.out.println(response.statusCode());
        }
    }

    public static String convertJsonFileToString(String filePath) {
        String content = "";
        try {
            // Reading the JSON file into a String
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) {
        try {
            String token = generateToken();
            System.out.println("Generated Token: " + token);
            String testKey = "POEI20252-522"; // Replace with your actual test key
            String outputZipPath = "C:\\Users\\IB\\Downloads\\Karate\\Karate\\src\\test\\resources\\feature\\features.zip"; // Change to a writable directory
            GetFeatures(token, testKey, outputZipPath);
            String newfiletosend = convertJsonFileToString("C:\\Users\\IB\\Downloads\\Karate\\Karate\\src\\test\\resources\\feature\\cucumber.json");
            sendTestResultsToXray(token,newfiletosend);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
