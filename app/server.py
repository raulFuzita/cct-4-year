import json
from flask import Flask, request, jsonify
# from werkzeug import ImmutableMultiDict
from app.controller.predictor.predictor_controller import PredictorController
from app.controller.geolocator.geolocator_controller import GeolocatorController
from app.controller.home.home_controller import HomeController

app = Flask(__name__)
 
@app.route("/")
def home_view():
    controller = HomeController()
    return controller.index()

@app.route("/search", methods=['POST'])
def search_api():

    if request.form:
        req = dict(request.form)
        req["api_key"] = request.args.get('api_key')
        
    if request.data:
        req = json.loads(request.data)

    controller = GeolocatorController(req)
    res = controller.get_location()
    return jsonify(res), res["status"]

@app.route("/predict", methods=['POST'])
def predict_api():
    
    if request.form:
        req = dict(request.form)
        req["api_key"] = request.args.get('api_key')

    if request.data:
        req = json.loads(request.data)
        print(req)

    controller = PredictorController(req)
    res = controller.predict()
    return jsonify(res), res["status"]