from geopy.geocoders.base import Geocoder

class Geolocator:
    def __init__(self, geolocator: Geocoder):
        """
        Initializes the geolocator
        param geolocator: Geolocator to be used
        """
        self.geolocator = geolocator
        self.timeout = 5

    def set_timeout(self, timeout: int):
        """
        Sets the timeout for the geolocator
        param timeout: Timeout in seconds
        """
        self.timeout = timeout

    def get_location(self, address: str) -> dict:
        """
        Returns the location of the address as a dictionary: {'latitude': latitude, 'longitude': longitude, 'address': address}
        param address: Address to be geocoded is a string
        """
        location = self.geolocator.geocode(address, timeout=self.timeout)
        return  {"latitude": location.latitude, "longitude": location.longitude, "address": location.address}


