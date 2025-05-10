import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SignLanguageApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView outputTextView = findViewById(R.id.outputTextView);

        app = new SignLanguageApp.Builder(this)
                .recognizer(new SignLanguageRecognizer(this))
                .outputTextView(outputTextView)
                .build();

        app.initialize();
    }

    // Lifecycle methods...
}