import json
from flask import Flask, request, jsonify
from app.controller.geolocator.geolocator_controller import GeolocatorController
from app.controller.home.home_controller import HomeController

GEOLOCATOR = "Nominatim"

app = Flask(__name__)
 
@app.route("/")
def home_view():
    controller = HomeController()
    return controller.index()

@app.route("/search", methods=['POST'])
def address_view():

    if request.form:
        req = {"api_key": request.args.get('api_key'), 
            "address": request.form['address']}
        
    if request.data:
        req = json.loads(request.data)

    controller = GeolocatorController(req)
    res = controller.get_location()
    print('Line:', res)
    return jsonify(res), res["status"]


