package com.example.movielibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {
    public final static String filter = "SMS_FILTER";
    public final static String msgKey = "SMS_MSG_KEY";

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (int i =0; i< messages.length; i++){
            SmsMessage currentMessage = messages[i];
            String msg =currentMessage.getDisplayMessageBody();

            Intent msgIntent = new Intent();
            msgIntent.setAction(filter);
            msgIntent.putExtra(msgKey,msg);
            context.sendBroadcast(msgIntent);
        }
    }
}
