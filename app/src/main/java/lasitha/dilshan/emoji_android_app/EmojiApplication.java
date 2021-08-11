package lasitha.dilshan.emoji_android_app;

import android.app.Application;

import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;

public class EmojiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Install emoji manager
        EmojiManager.install(new GoogleEmojiProvider());
    }
}
