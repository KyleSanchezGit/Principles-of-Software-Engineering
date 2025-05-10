import java.util.HashMap;
import java.util.Map;

public class SignLanguageInterpreter implements SignInterpreter {


    private Map<String, String> signMeanings;

    public SignLanguageInterpreter() {
        signMeanings = new HashMap<>();
        // Populate with sign language gestures and their meanings
        signMeanings.put("HAND_SHAPE_A", "A");
        signMeanings.put("HAND_SHAPE_B", "B");
        // Add more signs...
    }

    @Override
    public String interpret(String sign) {
        return signMeanings.getOrDefault(sign, "Unknown sign");
    }
}