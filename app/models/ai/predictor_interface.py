import abc

class Predictor(abc.ABC):
    """
    Abstract class for a predictor.
    """
    @abc.abstractmethod
    def predict(self, data):
        """
        Predict the class of a given data.
        """
        pass