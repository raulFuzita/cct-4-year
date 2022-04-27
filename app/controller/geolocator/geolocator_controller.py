import os
import json
from app.models.factory.geolocator_factory import GeolocatorFactory
from dotenv import load_dotenv

load_dotenv()

class GeolocatorController:
    def __init__(self, req: dict) -> json:
        self.req = req

    def get_location(self):

        if not 'api_key' in self.req:
            return {"response": "Missing API key", "status": 400,}

        if not 'address' in self.req:
            return {"response": "Missing address", "status": 400}

        api_key = self.req['api_key']
        address = self.req['address']

        if api_key != os.getenv("API_KEY") and api_key != os.getenv("API_KEY_TEST"):
            return {"response": "Invalid API key", "status": 403}

        geolocator_factory = GeolocatorFactory()
        geolocator = geolocator_factory.make("Nominatim")

        try:
            location = geolocator.get_location(address)
            return {"response": location, "status": 200}
        except Exception as e:
            return {"response": str(e), "status": 500}