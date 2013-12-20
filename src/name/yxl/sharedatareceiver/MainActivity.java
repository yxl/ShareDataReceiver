package name.yxl.sharedatareceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = getIntent();
		if (Intent.ACTION_SEND.equals(intent.getAction())) {
			handleSendIntent(intent);
		}
	}

	private void handleSendIntent(Intent intent) {
		String type = intent.getType();
		setTextViewText(R.id.mineType, type);
		String dataString = intent.getDataString();
		setTextViewText(R.id.dataString, dataString);
		Bundle extras = intent.getExtras();
		if (extras == null) {
			return;
		}
		String extraText = extras.getString(Intent.EXTRA_TEXT);
		setTextViewText(R.id.extraText, extraText);
		String extraTitle = extras.getString(Intent.EXTRA_TITLE);
		setTextViewText(R.id.extraTitle, extraTitle);
		String extraSubject = extras.getString(Intent.EXTRA_SUBJECT);
		setTextViewText(R.id.extraSubject, extraSubject);
	}
	
	private void setTextViewText(int id, String text) {
		TextView view = (TextView)this.findViewById(id);
		if (view != null) {
			view.setText(text);;
		}
	}
}
