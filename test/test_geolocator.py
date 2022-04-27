if __name__ == "__main__":
    import sys
    sys.path.append('..')

    import certifi
    import ssl
    import geopy.geocoders
    from geopy.geocoders import Nominatim
    from app.models.geolocators.geolocator import Geolocator

    ctx = ssl.create_default_context(cafile=certifi.where())
    geopy.geocoders.options.default_ssl_context = ctx
    
    geolocator = Geolocator(Nominatim(user_agent="propety-prediction-api"))

    location = geolocator.get_location("Wood Dale View, Woodale, Ballycragh, Firhouse Village ED, Tallaght, South Dublin, Dublin 24")
    print(location['address'])


    
    
    
    