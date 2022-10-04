package cucumber.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import support.GuiceScoped;

public class Hooks {

    @Inject
    private GuiceScoped guiceScoped;

    @After
    public void afterScenario() {
        try {
            if (guiceScoped.driver != null) {
                guiceScoped.driver.close();
                guiceScoped.driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
