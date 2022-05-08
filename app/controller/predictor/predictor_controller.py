import os
import json
import pandas as pd
from app.models.ai.property_predictor import PropertyPredictor
from dotenv import load_dotenv

load_dotenv()

class PredictorController:
    def __init__(self, req: dict) -> json:
        self.req = req

    def predict(self):

        if not 'api_key' in self.req:
            return {"response": "Missing API key", "status": 400,}

        api_key = self.req['api_key']

        if api_key != os.getenv("API_KEY") and api_key != os.getenv("API_KEY_TEST"):
            return {"response": "Invalid API key", "status": 403}

        model = PropertyPredictor('property_wt.pkl')
        model.load_predictors('property_predictors.json')
        predictors = model.get_predictors()

        if not set(predictors).issubset(self.req):
            return {"response": "Missing required fields", "status": 400}

        data = pd.DataFrame(self.req, index=[0])
        X_test = data[predictors]

        predictions = model.predict(X_test.to_numpy())
        print('Predictions: ', predictions)
        return {"response": predictions[0], "status": 200}