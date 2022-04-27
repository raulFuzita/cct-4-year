
if __name__ == "__main__":
    import sys
    sys.path.append('..')
    import pandas as pd
    import numpy as np
    import sklearn
    from sklearn.linear_model import LinearRegression
    from app.models.ai.property_predictor import PropertyPredictor

    # SALE_DATE  IF_MARKET_PRICE  IF_VAT_EXCLUDED  LONGITUDE   LATITUDE
    data = {
        'SALE_DATE': 2019, 
        'IF_MARKET_PRICE': 1, 
        'IF_VAT_EXCLUDED': 1, 
        'LONGITUDE': -6.283672, 
        'LATITUDE': 53.361690
    }

    # data = [[2019, 1, 1, -6.283672, 53.361690]]

    X_test = pd.DataFrame(data, index=[0])

    print(type(X_test))
    print(X_test)

    predictor = PropertyPredictor('property_wt.pkl')
    print(predictor.predict(X_test.to_numpy()))
    # print(predictor.predict(data))
    print('Test ran successfully')