package com.annotations;

@TesterInfo(createdBy = "Abhi", lastModified = "Sunday", priority = TesterInfo.Priority.HIGH, tags = {"sales", "test"})
public class TestExample {

    @Test
    void testA() {
        if(true) throw new RuntimeException("always failed");
    }

    @Test(enabled = false)
    void testB() {
        if(false ) throw new RuntimeException("alwasy passed");
    }

    @Test(enabled = true)
    void testC() {
        if (10 > 1) {
            // do nothing, this test always passed.
        }
    }

}
