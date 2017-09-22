package com.computas.chatbotchatlayout;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.List;

import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;


public class MainActivity extends AppCompatActivity implements AIListener {

    // Components
    EditText mTxtInput;
    ImageButton mBtnSendRequest;
    RecyclerView mRecyclerView;

    private ChatAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Message> mDataset;

    // ApiAi services
    private AIDataService aiDataService;
    private final String ACCESS_TOKEN = "*** INSERT TOKEN HERE ***";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        findViews();
        mDataset = new ArrayList<Message>();
        initRecyclerView();
        addClickListeners();

        // Initialize ApiAi service
        initService();

    }

    private void initRecyclerView(){
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ChatAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void findViews(){
        mTxtInput = (EditText) findViewById(R.id.txtChatInput);
        mBtnSendRequest = (ImageButton) findViewById(R.id.btnSend);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    private void addClickListeners(){
        mBtnSendRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String query = mTxtInput.getText().toString();
                mTxtInput.setText("");
                sendRequestToApiAi(query);
            }
        });
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
    public void sendRequestToApiAi(String query){

        if (TextUtils.isEmpty(query)) {
            return;
        }


        mAdapter.addItem(new Message(query, ChatAdapter.VIEWTYPE_USER));

        AIRequest aiRequest = new AIRequest();
        aiRequest.setQuery(query);

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
                mAdapter.addItem(new Message(response.getResult().getFulfillment().getSpeech(), ChatAdapter.VIEWTYPE_BOT ) );
            }
        });
    }

    // Gets the error message if call to ApiAi fails.
    @Override
    public void onError(final AIError error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.addItem(new Message(error.getMessage(), ChatAdapter.VIEWTYPE_BOT ) );

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
