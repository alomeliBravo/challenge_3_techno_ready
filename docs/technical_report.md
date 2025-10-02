# What is SerpAPI?

**SerpAPI** is a real time API service that enables developers to extract structured data from
search engine result pages without the need to handle web scraping, CAPTCHAs, or proxy
management manually. It provide standardized JSON responses for queries across multiple
search engines like Google, Bing, Yahoo, Yandex, etc. And supports features like image,
news, shopping and maps results. This makes it useful for applications such as SEO
monitoring, market research, competitive analysis, and data-driven automation.

# Endpoints

**SerpAPI** only have one endpoint to use, this endpoint is “/search”.
And you can only use the **GET** method to obtain a response.

# Authentication methods

First of all, to use SerpAPI you need to create an account, once you have an account you will
see that SerpAPI provide you and API_KEY to authenticate you when you use the API, this
API_KEY need to be provided as a parameter when you do a request to the endpoint.

# Query Parameters

**SerpAPI** have a lot of query parameters to use, but it only require 2 query parameters that are
“ **q”** and “ **api_key”.**
This 2 parameters are the essentials and the most important to use the API, **q** is the search
query, so if you want to search something like “coffe shop” you need to put it on **q** parameter,
the api_key is the most important parameter because without this parameter you will have a
bad response.
After this two important parameters you can use parameter to provide location, the engine
browser like Google, Yahoo, Yandex, etc.
Short list of query parameters that can be used:
● location
● google_domain
● hl (To especify a language)
● cr (Define one or multiple countries to timit the search to)
● lr (Defines one or multiple languages)
● safe (Defines the level of filtering)
● engine (Defines the engine browser)
● start (Defines the result offset)


# Response formats

**SerpAPI** gives you two formats, JSON and HTML, when you make a request you need to
specify in the URL the type of response you want, for example:
**JSON format** :
https://serpapi.com/search.json
**HTML format** (default):
https://serpapi.com/search.html

# Usage limits:

**SerpAPI** provides a free layer of 250 request to the API, once you pass the 250 requests limit
you need to pay for a subscription.

# Code examples

**Java:**
Map<String, String> parameter = new HashMap<>();
parameter.put("engine", "google");
parameter.put("q", "Coffee");
parameter.put("api_key",
"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
GoogleSearch search = new GoogleSearch(parameter);
try {
JsonObject results = search.getJson();
var organic_results = results.get("organic_results");
} catch (SerpApiSearchException ex) {
System.out.println("Exception:");
System.out.println(ex.toString());
}


**JavaScript:**
const { getJson } = require("serpapi");
getJson({
engine: "google",
q: "Coffee",
api_key: "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
}, (json) => {
console.log(json["organic_results"]);
});
**Python:**
from serpapi import GoogleSearch
params = {
"engine": "google",
"q": "Coffee",
"api_key": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
}
search = GoogleSearch(params)
results = search.get_dict()
organic_results = results["organic_results"]


