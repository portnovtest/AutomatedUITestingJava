package com.sample.tests.junit.kdt;

import com.sample.framework.utils.jira.JiraUtils;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class GenerateTest {

    @BeforeClass
    public static void farBefore() throws Exception {
        String featurePath = "build/features";
        Map<String,String> content = JiraUtils.getField("http://localhost:9090","portnov","test",
                "project = SAM AND type = Test AND status in (Done, Failed, Passed)", "description");
        for (Map.Entry<String, String> entry : content.entrySet()) {
            String fileName = entry.getKey().replaceAll("(\\W+)","_") + ".feature";
            String result = "@gen @" + entry.getKey().split(" ")[0] + System.lineSeparator() + entry.getValue();
            File output = new File(featurePath + File.separator + fileName);
            output.getParentFile().mkdirs();
            FileUtils.writeStringToFile(new File(featurePath + File.separator + fileName),
                    result, "UTF-8");
        }
    }
    @Test
    public void testRun(){}
}
