package com.computas.chatbotchatlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Thomas Hauglid on 21.09.2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Message> mDataset;
    public static final int VIEWTYPE_BOT = 0;
    public static final int VIEWTYPE_USER = 1;


    public ChatAdapter(List<Message> mDataset){
        this.mDataset = mDataset;
    }

    public void addItem(Message message){
        mDataset.add(message);
        notifyItemInserted(mDataset.size() - 1);
    }

    /*
        Gets the correct layout for the message (User/bot)
        Returns a new instance of the viewholder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ChatAdapter.VIEWTYPE_BOT){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_bot_layout, parent, false);
            return new BotViewHolder(v);

        }else if (viewType == ChatAdapter.VIEWTYPE_USER){
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_user_layout, parent, false);
            return new UserViewHolder(v);
        }

        return null;
    }

    /*
        Puts data in the layout, i.e. the text to be displayed.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UserViewHolder){
            ((UserViewHolder) holder).mTextView.setText(mDataset.get(position).getMessage());

        }
        else if (holder instanceof BotViewHolder){
            ((BotViewHolder) holder).mTextView.setText(mDataset.get(position).getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    
    @Override
    public int getItemViewType(int position) {
        return mDataset.get(position).getViewType();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public UserViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txtChatUser);
        }
    }

    public class BotViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public BotViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txtChatBot);
        }
    }





}
