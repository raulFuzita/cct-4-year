import os
import certifi
import ssl
import geopy.geocoders
from geopy.geocoders import Nominatim
from geopy.geocoders import GoogleV3
import googlemaps
from dotenv import load_dotenv
from app.models.geolocators.geolocator import Geolocator


ctx = ssl.create_default_context(cafile=certifi.where())
geopy.geocoders.options.default_ssl_context = ctx

load_dotenv()

class GeolocatorFactory:
    def __init__(self):
        pass

    def make(self, geolocator_name: str) -> Geolocator:
        """
        Returns a geolocator object based on the geolocator_name
        param: geolocator_name is a string that represents the geolocator to be used.
        Possible values: Nominatim, Google
        exception: Exception if geolocator_name is not a valid value
        exception: Exception if GoogleV3 is used and the API key is not set or is invalid
        """
        if geolocator_name == "Nominatim":
            user_agent=os.getenv("APP_NAME")
            if user_agent:
                geolocator = Nominatim(user_agent=user_agent)
            else:
                geolocator = Nominatim(user_agent="propety-prediction-api")
        elif geolocator_name == "Google":
            google_api_key = os.getenv("GOOGLE_API_KEY")
            if google_api_key:
                geolocator = GoogleV3(api_key=google_api_key)
            else:
                raise Exception("Google API key is missing")
        else:
            raise Exception("Invalid geolocator name")
        return Geolocator(geolocator)