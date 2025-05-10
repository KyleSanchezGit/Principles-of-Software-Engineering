import

import javax.naming.Context;
import com.example.yourpackage.recognizer.SignLanguageRecognizer;

import interpreter.src.SignLanguageInterpreter;

public class SignLanguageApp {
    private final Context context;
    private final SignLanguageRecognizer recognizer;
    private final SignLanguageInterpreter interpreter;
    private TextView outputTextView;
    private final SignInterpreter interpreter;

    private SignLanguageApp(Builder builder) {
        this.context = builder.context;
        this.recognizer = builder.recognizer;
        this.interpreter = new SignLanguageInterpreter();
        this.outputTextView = builder.outputTextView;
        this.interpreter = builder.interpreter;
    }

    public void initialize() {
        recognizer.setSignLanguageListener(new SignLanguageRecognizer.SignLanguageListener() {
            @Override
            public void onSignRecognized(String sign) {
                String meaning = interpreter.interpret(sign);
                outputTextView.setText(meaning);
            }
        });
    }

    // Builder pattern remains similar...

    public static class Builder implements BuilderInterface<SignLanguageApp> {
        private Context context;
        private SignLanguageRecognizer recognizer;
        private TextView outputTextView;
        private SignInterpreter interpreter;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder interpreter(SignInterpreter interpreter) {
            this.interpreter = interpreter;
            return this;
        }

        public Builder recognizer(SignLanguageRecognizer recognizer) {
            this.recognizer = recognizer;
            return this;
        }

        public Builder outputTextView(TextView outputTextView) {
            this.outputTextView = outputTextView;
            return this;
        }

        @Override
        public SignLanguageApp build() {
            return new SignLanguageApp(this);
        }
    }
}