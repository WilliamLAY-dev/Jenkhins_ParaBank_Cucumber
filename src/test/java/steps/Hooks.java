package steps;

import Automatisation.XRayFeatureUploader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseTest;

import java.io.IOException;

public class Hooks {

    String testKey = "POEI20252-522"; // Replace with your actual test key
    String outputZipPath = "C:\\Users\\IB\\Downloads\\Karate\\Karate\\src\\test\\resources\\feature\\features.zip";
    String unzipfileDestination = "C:\\Users\\IB\\Downloads\\Karate\\Karate\\src\\test\\resources\\feature\\result.feature";
    String result;
    String token = XRayFeatureUploader.generateToken();

    @Before
    public void setup() throws IOException {

        BaseTest.getDriver();

    }

    @After
    public void tearDown() throws IOException {

        BaseTest.quitDriver();
    }
}
