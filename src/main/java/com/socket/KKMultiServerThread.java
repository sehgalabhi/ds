package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by asehgal on 5/10/2017.
 */
public class KKMultiServerThread extends Thread {
    private Socket socket = null;

    String a = "MIIDmDCCAoCgAwIBAgIEEk+FgzANBgkqhkiG9w0BAQsFADBNMQswCQYDVQQGEwJOTDEPMA0GA1UEChMGUmFtYnVzMRQwEgYDVQQLEwtEZXZlbG9wbWVudDEXMBUGA1UEAxMOQ0EtU0QtUk9PVC5BVVQwIBcNMTcxMDI2MTQxMzIzWhgPMjA2NzEwMTQxNDEzMjNaMIGIMQswCQYDVQQGEwJOTDEPMA0GA1UEChMGUmFtYnVzMRQwEgYDVQQLEwtEZXZlbG9wbWVudDEeMBwGA1UEAxMVREVWSUNFMS5DQS1TRC1EUksuQVVUMTIwMAYKCZImiZPyLGQBARMiUEhOLVA6MjAxNTA3MzA6MDE6MDc6MDAzNTA2NTg6Uk9PVDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBANYlSlTJeTDfxO8rVLNNeVuoFvOH99+RLut9gNkrxtqODyY2hBnf0ljrT2hppvTS07CCm6qgjxmy0qWHtkmnh4naVon8Dyp6yRfYmmXcW1Bcy3v6OQ4zWLh11yFLqgrevGqjCLcWiVSXMVK2p2dMgb12fV9APqH7fRI4pdSghUi65MV/FFbXSmD+6GPuoFlYvkQCgUCTOgI/ay2d/oVE3yelSvBCLPwqw1I/TvUKnNoexCUYbi+dtlunk+/rE0Ahp2+E14+9AiR5EubjP1s7DuHoJf4m+4hamlDAsEXSVchhILTmLqNfNS4w632cfvGWEeH9UV4eCBR8YmHFfiG9za0CAwEAAaNCMEAwHwYDVR0jBBgwFoAU1Tyjd57W6BUgkiEdh644lxfzvDkwHQYDVR0OBBYEFKd9e14CmsRRDeNSE6RPg6Trg50pMA0GCSqGSIb3DQEBCwUAA4IBAQCQvr7EQg5SSamxq+0mhlsMooemA/bPhGN/WMNFQlfbA26JsU7Ks0m2mQiTZ6PhQS2wyjuUcLNv9LPOk0CqeUOxm6ZxBeWe8VMteS4RSKexlxCASJMNwe9OuiWYsX8/RMurZ8pidwjnHyeuDPR9CMBEFUcpFzZagNiaUYm5fVC14mR2vAjBpJNuARTQf42RyPD5++W3clDNItUHO7eog169A2sjvpQcHDoI61QKJcjWOp/tkcAqkRnOiimH1ehtCAwiz+mKm/JapNv3PkTTS6T/pvNDYWc/PK/vRHz0ZqvUoR8rjXtKgs7cQfHFW9akBLKa6TEuRUD3MSqj+AnRpOAF";

    public KKMultiServerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        ) {
            String inputLine, outputLine;
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Socket port " + socket.getRemoteSocketAddress() + " writing " + inputLine);
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye"))
                    break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
