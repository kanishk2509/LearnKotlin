package com.kanishk.prototypes.mvvm_sample.Bus.Event;

import android.content.Intent;

/**
 * Created by kanishk on 03/06/17.
 */

public interface IntentEvent {
    void onIntentReceived(Intent intent);
}
