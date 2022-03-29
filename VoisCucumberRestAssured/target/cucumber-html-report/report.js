$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("coloursPatterns.feature");
formatter.feature({
  "line": 1,
  "name": "Colour patterns API",
  "description": "I want to test colour patterns for colour lovers api",
  "id": "colour-patterns-api",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User set GET colour patterns endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User set request header",
  "keyword": "And "
});
formatter.match({
  "location": "ColourPatternsSteps.user_want_to_execute_GET_colour_patterns_endpoint()"
});
formatter.result({
  "duration": 247983500,
  "status": "passed"
});
formatter.match({
  "location": "ColourPatternsSteps.user_submit_GET_request()"
});
formatter.result({
  "duration": 2110481600,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Send valid request to GET colour patterns",
  "description": "",
  "id": "colour-patterns-api;send-valid-request-to-get-colour-patterns",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "User submit GET request to colour lovers",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User should receive valid status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "ColourPatternsSteps.submit_GET_request()"
});
formatter.result({
  "duration": 2795835600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 38
    }
  ],
  "location": "ColourPatternsSteps.user_should_get_success_status_code(int)"
});
formatter.result({
  "duration": 8308800,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User set GET colour patterns endpoint",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User set request header",
  "keyword": "And "
});
formatter.match({
  "location": "ColourPatternsSteps.user_want_to_execute_GET_colour_patterns_endpoint()"
});
formatter.result({
  "duration": 379300,
  "status": "passed"
});
formatter.match({
  "location": "ColourPatternsSteps.user_submit_GET_request()"
});
formatter.result({
  "duration": 1662300,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify that \"numViews\" is greater than 4000",
  "description": "",
  "id": "colour-patterns-api;verify-that-\"numviews\"-is-greater-than-4000",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "User submit GET request to colour lovers",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Verify numViews is greater than 4000",
  "keyword": "Then "
});
formatter.match({
  "location": "ColourPatternsSteps.submit_GET_request()"
});
formatter.result({
  "duration": 348922300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4000",
      "offset": 32
    }
  ],
  "location": "ColourPatternsSteps.verify_numViews_value_range(int)"
});
formatter.result({
  "duration": 2102702200,
  "status": "passed"
});
});