
if __name__ == "__main__":
    import sys
    import os
    sys.path.append('..')
    from app.controller.predictor.predictor_controller import PredictorController
    from dotenv import load_dotenv

    load_dotenv()

    api_key = os.getenv("API_KEY_TEST")
    
    data = {
        "bedrooms": 3,
        "bathrooms": 1,
        "property_size": 98,
        "longitude": -9.08907,
        "latitude": 53.28038,
        "property_type": 9,
        "year": 2022,
        "api_key": api_key
    }

    controller = PredictorController(data)
    print(controller.predict())
    print('Test ran successfully')