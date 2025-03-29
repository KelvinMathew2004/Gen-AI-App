package apiOperations;

import org.json.JSONArray;
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

        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", "user").put("content", userPrompt));

        body.put("messages", messages);
        body.put("max_tokens", 200);

        return body;

    }

    // @Override
    // protected String parseResponse(String jsonResponse) {
    //     try {
    //         JSONObject json = new JSONObject(jsonResponse);
    //         return json.getJSONArray("choices")
    //                 .getJSONObject(0)
    //                 .getJSONObject("message")
    //                 .getString("content");
    //     } catch (JSONException e) {
    //         return ("Unable to parse OpenAI JSON response " + e.getMessage());
    //     }
    // }
}