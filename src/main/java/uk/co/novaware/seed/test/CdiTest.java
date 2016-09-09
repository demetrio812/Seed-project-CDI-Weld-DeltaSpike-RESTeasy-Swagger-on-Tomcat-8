package uk.co.novaware.seed.test;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CdiTest {

    public String getTestName() {
        return "CDI";
    }
}
