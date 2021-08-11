package lasitha.dilshan.emoji_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {
    //Initialize variables
    ImageView btEmoji,btSend;
    EditText etEmoji;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variables
        btEmoji = findViewById(R.id.bt_emoji);
        btSend = findViewById(R.id.bt_send);
        etEmoji = findViewById(R.id.et_emoji);
        linearLayout = findViewById(R.id.linear_layout);

        //Initialize emoji popup
        EmojiPopup popup = EmojiPopup.Builder.fromRootView(
                findViewById(R.id.root_view)
        ).build(etEmoji);

        btEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toggle between text and emoji
                popup.toggle();
            }
        });

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflate emoji text view
                EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater
                        .from(v.getContext())
                        .inflate(R.layout.emoji_text_view,linearLayout,false);
                //Set text on emoji text view
                emojiTextView.setText(etEmoji.getText().toString());
                //Add view to linear layout
                linearLayout.addView(emojiTextView);
                //Clear edit text value
                etEmoji.getText().clear();
            }
        });

    }
}