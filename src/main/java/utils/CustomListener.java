package utils;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomListener extends AllureCucumber5Jvm {

    private final AllureLifecycle lifecycle = Allure.getLifecycle();

    @Override
    public void setEventPublisher(final EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if (testStepFinished.getResult().getStatus().equals(Status.FAILED)) {
                String kek = "kekes";
                //Allure.addAttachment("Report", "text/plain", kek, "txt");
                this.lifecycle.addAttachment("Report", "text/plain", "txt", serialize(kek));
                this.lifecycle.addAttachment("Report", "image/png", "png", addScreenshot());
                //addScreenshot();
            }
        });

        super.setEventPublisher(publisher);
    }

    public static byte[] serialize(Object obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    //@Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
