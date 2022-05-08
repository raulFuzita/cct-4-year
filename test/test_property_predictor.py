
if __name__ == "__main__":
    import sys
    sys.path.append('..')
    import pandas as pd
    from app.models.ai.property_predictor import PropertyPredictor

    data = {
        "bedrooms": 3,
        "bathrooms": 1,
        "property_size": 98,
        "longitude": -9.08907,
        "latitude": 53.28038,
        "property_type": 9,
        "year": 2022
    }

    # data = [[2019, 1, 1, -6.283672, 53.361690]]

    X_test = pd.DataFrame(data, index=[0])

    print(type(X_test))
    print(X_test)

    model = PropertyPredictor('property_wt.pkl', 'property_predictors.json')
    X_test = X_test[model.get_predictors()]
    print(model.predict(X_test.to_numpy()))
    # print(predictor.predict(data))
    print('Test ran successfully')