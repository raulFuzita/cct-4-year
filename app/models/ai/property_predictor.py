import os
import pickle
import sklearn
from os.path import dirname, join, exists
from .predictor_interface import Predictor

class PropertyPredictor(Predictor):
    """
    Predictor for the properties of a given data.
    """
    def __init__(self, model_name):
        """
        Initialize the predictor.
        """
        path = '../../ai/models/{}'.format(model_name)
        output_path = join(dirname(__file__), *path.split('/'))
        isfile = exists(output_path)

        print('ML model directory:', output_path)
        print('Model exist:', isfile)
        try:
            self.model = pickle.load(open(output_path, 'rb'))
        except Exception as e:
            print('Error loading model:', e)
            raise e

    def predict(self, data):
        """
        Predict the properties of a given data.
        """
        return self.model.predict(data)