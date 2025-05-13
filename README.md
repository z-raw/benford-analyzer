# Benford's Analyzer

A simple MVP built on Ktor to test the fascinating Benford's Law.

Benford's law, also known as the Newcomb–Benford law, the law of anomalous numbers, or the first-digit law, is an observation that in many real-life sets of numerical data, the leading digit is likely to be small.
One of the applications of this law is in anamoloy/fraud detection, as it is difficult for made up numbers to conform to the law.

## Running

Execute this command to run the project:

```bash
./gradlew run
```

## API

Sample Request:
```bash
curl --location '0.0.0.0:8080/api/analyze' \
--header 'Content-Type: application/json' \
--data '{
    "documentText": "some text and numbers 10 24 133 999 333 558 more text 77 55 8 9 6 5 9 8 7 666 7 8 9",
    "significanceLevel": 0.01
}'
```

Sample Response:
```
200 OK

{
    "followsBenfordsLaw": false,
    "distribution": [
        {
            "digit": 1,
            "actualCount": 2,
            "actualPercentage": 10.526315789473683,
            "expectedCount": 5.719569917615643,
            "expectedPercentage": 30.10299956639812
        },
        {
            "digit": 2,
            "actualCount": 1,
            "actualPercentage": 5.263157894736842,
            "expectedCount": 3.3457339220579434,
            "expectedPercentage": 17.609125905568124
        },
        {
            "digit": 3,
            "actualCount": 1,
            "actualPercentage": 5.263157894736842,
            "expectedCount": 2.3738359955576986,
            "expectedPercentage": 12.493873660829992
        },
        {
            "digit": 4,
            "actualCount": 0,
            "actualPercentage": 0.0,
            "expectedCount": 1.8412902471530719,
            "expectedPercentage": 9.691001300805642
        },
        {
            "digit": 5,
            "actualCount": 3,
            "actualPercentage": 15.789473684210526,
            "expectedCount": 1.5044436749048715,
            "expectedPercentage": 7.918124604762482
        },
        {
            "digit": 6,
            "actualCount": 2,
            "actualPercentage": 10.526315789473683,
            "expectedCount": 1.2719890029816512,
            "expectedPercentage": 6.694678963061322
        },
        {
            "digit": 7,
            "actualCount": 3,
            "actualPercentage": 15.789473684210526,
            "expectedCount": 1.101846992576048,
            "expectedPercentage": 5.799194697768673
        },
        {
            "digit": 8,
            "actualCount": 3,
            "actualPercentage": 15.789473684210526,
            "expectedCount": 0.9718979265002445,
            "expectedPercentage": 5.115252244738129
        },
        {
            "digit": 9,
            "actualCount": 4,
            "actualPercentage": 21.052631578947366,
            "expectedCount": 0.8693923206528277,
            "expectedPercentage": 4.575749056067514
        }
    ],
    "significanceLevel": 0.01,
    "message": "The data does NOT appear to follow Benford's Law at the 1.0% significance level. Warning: The number of data points is low (less than 50). Chi-square test results may not be reliable."
}
```
