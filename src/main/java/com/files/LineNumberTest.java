package com.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LineNumberTest {

    public static void main(String[] args) throws IOException {
        new LineNumberTest().test();
    }

    private void test() throws IOException {
        Path scenarioPath = Paths.get("test-scenario-1.txt");
        System.out.println(scenarioPath.toFile().getAbsolutePath());

        BufferedReader bufferedReader = new BufferedReader(new FileReader(scenarioPath.toFile()));

        Map<String, List<OfflineTransitTestAction>> actionsToExecute = new HashMap<>();
        List<OfflineTransitTestAction> temp = new ArrayList<>();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {

            if (currentLine.startsWith(">>>END")) {
                break;
            } else if (currentLine.startsWith(">>>")) {
                temp = new ArrayList<>();
                actionsToExecute.put(currentLine.substring(currentLine.indexOf(">>>"), currentLine.length()), temp);

            } else if (!currentLine.isEmpty() && !currentLine.startsWith("#")) {

                String[] split = currentLine.split(",", 7);
                OfflineTransitTestAction offlineTransitTestAction = new OfflineTransitTestAction(Action.valueOf(split[0].trim()), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim());
                temp.add(offlineTransitTestAction);
            }
        }
        List<Object[]> objects = actionsToExecute.entrySet().stream().map(t -> new Object[]{t.getKey(), t.getValue()}).collect(Collectors.toList());


        System.out.println(temp);
    }

    private static class OfflineTransitTestAction {
        private Action action;
        private String atc;
        private String tokenPan;
        private String amount;
        private String additionalInfo;
        private String fileName;
        private String tspValidationResultDF78;

        private OfflineTransitTestAction(Action action, String atc, String tokenPan, String amount, String additionalInfo, String fileName, String tspValidationResultDF78) {
            this.action = action;
            this.atc = atc;
            this.tokenPan = tokenPan;
            this.amount = amount;
            this.additionalInfo = additionalInfo;
            this.fileName = fileName;
            this.tspValidationResultDF78 = tspValidationResultDF78;
        }

        public Action getAction() {
            return action;
        }

        public String getAtc() {
            return atc;
        }

        public String getTokenPan() {
            return tokenPan;
        }

        public String getAmount() {
            return amount;
        }

        public String getAdditionalInfo() {
            return additionalInfo;
        }

        public String getFileName() {
            return fileName;
        }

        public String getTspValidationResultDF78() {
            return tspValidationResultDF78;
        }
    }

    enum Action {
        REPLENISHMENT,
        TRANSACTION
    }
}
