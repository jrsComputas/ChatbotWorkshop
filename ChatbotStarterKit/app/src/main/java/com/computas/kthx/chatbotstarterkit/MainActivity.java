package com.computas.kthx.chatbotstarterkit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.computas.kthx.chatbotstarterkit.precompile.EnterKeyActivity;

import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;


public class MainActivity extends AppCompatActivity implements AIListener {

    // Components
    EditText txtInput;
    Button btnSendRequest;
    Button btnClearText;
    TextView txtOutput;

    // ApiAi services
    private AIDataService aiDataService;
    private String ACCESS_TOKEN = "*** INSERT TOKEN HERE ***";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent() != null)
            if(getIntent().hasExtra(EnterKeyActivity.API_AI_KEY))
                ACCESS_TOKEN = getIntent().getStringExtra(EnterKeyActivity.API_AI_KEY);

        setContentView(R.layout.activity_main);

        // Initialize components
        findViews();
        addClickListeners();

        // Initialize ApiAi service
        initService();

    }

    private void findViews(){
        txtInput = (EditText) findViewById(R.id.txtInput);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        btnClearText = (Button) findViewById(R.id.btnClearText);
        btnSendRequest = (Button) findViewById(R.id.btnSend);
    }

    private void addClickListeners(){
        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendRequestToApiAi();
            }
        });

        btnClearText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearTextViews();
            }
        });
    }

    private void clearTextViews(){
        txtOutput.setText("");
        txtInput.setText("");
    }

    private void initService() {
        final AIConfiguration config = new AIConfiguration(ACCESS_TOKEN,
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiDataService = new AIDataService(this, config);

    }

    /*
        Gets the input string
        Make a new AIRequest
        Send request to ApiAi in a new thread (doInBackground)
        Handle response (onPostExecute)
     */
    public void sendRequestToApiAi(){
        String queryString = txtInput.getText().toString();

        if (TextUtils.isEmpty(queryString)) {
            txtOutput.setText("String cannot be empty");
            return;
        }

        AIRequest aiRequest = new AIRequest();
        aiRequest.setQuery(queryString);

        // Run in the background
        new AsyncTask<AIRequest, Void, AIResponse>() {
            private AIError aiError;

            @Override
            protected AIResponse doInBackground(AIRequest... requests) {
                final AIRequest request = requests[0];
                try {
                    final AIResponse response = aiDataService.request(request);
                    return response;
                } catch (AIServiceException e) {
                    aiError = new AIError(e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(AIResponse aiResponse) {
                if (aiResponse != null) {
                    onResult(aiResponse);
                    // process aiResponse here
                }else{
                    onError(aiError);
                }
            }
        }.execute(aiRequest);

    }


    // Gets the result from ApiAi, and "print" to screen
    @Override
    public void onResult(final AIResponse response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtOutput.setText(response.getResult().getFulfillment().getSpeech());
            }
        });
    }

    // Gets the error message if call to ApiAi fails.
    @Override
    public void onError(final AIError error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtOutput.setText(error.toString());
            }
        });
    }

    /* Ignore, not used when sending text requests. */
    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
