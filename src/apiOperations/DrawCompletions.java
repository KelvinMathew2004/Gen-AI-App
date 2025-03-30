package apiOperations;

import org.json.JSONException;
import org.json.JSONObject;

public class DrawCompletions extends AbstractOpenAIRequest {
    private String userPrompt;

    public DrawCompletions(String apiKey, String model, String userPrompt) {
        super(apiKey, model); // Pass apiKey and model to the abstract class constructor
        this.userPrompt = userPrompt;
    }

    @Override
    protected JSONObject constructRequestBody() throws JSONException {
        JSONObject body = new JSONObject();
        body.put("model", model);
        body.put("prompt", userPrompt);
        body.put("n", 1);
        body.put("size", "1024x1024");
        return body;
    }

    @Override
    protected String parseResponse(String jsonResponse) {
        try {
            JSONObject json = new JSONObject(jsonResponse);
            return json.getJSONArray("data").getJSONObject(0).getString("url");
        } catch (JSONException e) {
            return "Unable to parse OpenAI JSON response: " + e.getMessage();
        }
    }
}