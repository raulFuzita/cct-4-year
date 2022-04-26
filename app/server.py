
import os
from flask import Flask
 
app = Flask(__name__)
 
@app.route("/")
def home_view():
        return  """
                <h1>Welcome to Property Prediction</h1>
                <p>This is a simple web application that predicts the price of a property based on the features of the property.</p>
                <p>Author: <a href="https://github.com/raulFuzita/cct-4-year/tree/property-prediction">Raul Fuzita GitHub</a></p>
                """