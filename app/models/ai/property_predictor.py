import os
import pickle
import json
import sklearn
from os.path import dirname, join, exists
from .predictor_interface import Predictor

class PropertyPredictor(Predictor):
    """
    Predictor for the properties of a given data.
    """
    def __init__(self, model_name:str=None, predictor_name:str=None):
        self.ai_models = '../../ai/models/'
        if model_name:
            self.load_model(model_name)
        if predictor_name:
            self.load_predictors(predictor_name)

    def __get_full_path(self, file_name:str):
        """
        Get the full path of a given file.
        """
        path = self.ai_models + file_name
        return join(dirname(__file__), *path.split('/'))

    def __get_file_status(self, full_path:str):
        isfile = exists(full_path)
        print('ML model directory:', full_path)
        print('Model exist:', isfile)

    def load_model(self, model_name:str):
        """
        Load a model.
        """
        full_path = self.__get_full_path(model_name)
        self.__get_file_status(full_path)
        try:
            self.model = pickle.load(open(full_path, 'rb'))
        except Exception as e:
            print('Error loading model:', e)
            raise e

    def load_predictors(self, predictor_name:str):
        """
        Load the predictors.
        """
        full_path = self.__get_full_path(predictor_name)
        self.__get_file_status(full_path)
        try:
            self.predictors = list(json.load(open(full_path, 'r')))
        except Exception as e:
            print('Error loading predictors:', e)
            raise e

    def get_predictors(self) -> list:
        """
        Get the predictors.
        """
        return self.predictors

    def set_predictors(self, predictors: list):
        """
        Set the predictors.
        """
        self.predictors = list(predictors)

    def get_model(self):
        """
        Get the model.
        """
        return self.model

    def set_model(self, model):
        """
        Set the model.
        """
        self.model = model

    def predict(self, data: list):
        """
        Predict the properties of a given data.
        """
        return self.model.predict(data)

    def get_ai_models(self) -> str:
        """
        Get the AI models.
        """
        return self.ai_models

    def set_ai_models(self, ai_models: str):
        """
        Set the AI models.
        """
        self.ai_models = ai_models