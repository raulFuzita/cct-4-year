
if __name__ == "__main__":
    import sys
    sys.path.append('..')
    from app.controller.predictor.predictor_controller import PredictorController
    
    data = {
        'api_key': 'full_privilege',
        'SALE_DATE': 2019, 
        'IF_MARKET_PRICE': 1, 
        'IF_VAT_EXCLUDED': 1, 
        'LONGITUDE': -6.283672, 
        'LATITUDE': 53.361690
    }

    controller = PredictorController(data)
    print(controller.predict())
    print('Test ran successfully')